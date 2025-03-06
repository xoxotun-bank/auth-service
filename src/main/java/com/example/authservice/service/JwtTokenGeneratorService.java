package com.example.authservice.service;

import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;
import java.time.*;
import java.util.*;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import com.example.authservice.configuration.JwtGeneratorProperties;
import com.example.authservice.model.token.AccessToken;
import com.example.authservice.model.token.RefreshTokenEntity;
import com.example.authservice.repository.RefreshTokensRepository;
import lombok.*;

@RequiredArgsConstructor
public class JwtTokenGeneratorService {

    private static final String RSA_ALGORITHM_FAMILY = "RSA";

    private final JwtGeneratorProperties jwtGeneratorProperties;

    private final Algorithm algorithm;

    private final ZoneId timeZoneId;

    private final RefreshTokensRepository refreshTokensRepository;

    public static JwtTokenGeneratorService of(
        JwtGeneratorProperties properties,
        RefreshTokensRepository repository
    ) {
        var key = buildPrivateKey(properties.privateKey(), RSA_ALGORITHM_FAMILY);
        var algorithm = Algorithm.RSA256(null, key);
        var timeZoneId = ZoneId.of(properties.zoneId());
        return new JwtTokenGeneratorService(properties, algorithm, timeZoneId, repository);
    }

    static RSAPrivateKey buildPrivateKey(String privateKey, String algorithm) {
        var keyBytes = Base64.getDecoder().decode(privateKey);
        var keySpec = new PKCS8EncodedKeySpec(keyBytes);

        try {
            var keyFactory = KeyFactory.getInstance(algorithm);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception ex) {
            throw new RuntimeException(String.format(
                "Error on building private key(%s): %s",
                algorithm, privateKey
            ), ex);
        }
    }

    public String generateAccessToken(AccessToken token) {
        var issuedAt = ZonedDateTime.now(timeZoneId);
        var expiredAt = issuedAt.plusSeconds(jwtGeneratorProperties.accessTokenExpiredOnSeconds());

        var jwt = JWT.create()
            .withJWTId(token.getJti().toString())
            .withClaim("user_id", token.getUserId())
            .withIssuedAt(issuedAt.toInstant())
            .withExpiresAt(expiredAt.toInstant())
            .withClaim("roles", token.getRoles())
            .withClaim("city", token.getCity())
            .withClaim("region", token.getRegion())
            .sign(algorithm);

        return jwt;
    }

    public RefreshTokenEntity createRefreshTokenEntity(Integer userId, UUID accessTokenJti) {
        var issuedAt = ZonedDateTime.now(timeZoneId);
        var expiredAt = issuedAt.plusSeconds(jwtGeneratorProperties.refreshTokenExpiredOnSeconds());

        var entity = RefreshTokenEntity.builder()
            .userId(userId)
            .accessTokenJti(accessTokenJti)
            .refreshTokenJti(UUID.randomUUID())
            .issuedAt(issuedAt)
            .expiredAt(expiredAt)
            .build();

        refreshTokensRepository.save(entity);

        return entity;
    }

    public String generateRefreshToken(RefreshTokenEntity token) {
        var jwt = JWT.create()
            .withClaim("id", token.getId())
            .withClaim("user_id", token.getUserId())
            .withClaim("access_token_jti", token.getAccessTokenJti().toString())
            .withJWTId(token.getRefreshTokenJti().toString())
            .withIssuedAt(token.getIssuedAt().toInstant())
            .withExpiresAt(token.getExpiredAt().toInstant())
            .sign(algorithm);

        return jwt;
    }

}
