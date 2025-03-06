package com.example.authservice.service;

import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;
import java.time.*;
import java.util.*;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.*;
import com.example.authservice.configuration.JwtValidatorProperties;
import com.example.authservice.exception.InvalidAccessTokenException;
import com.example.authservice.exception.InvalidRefreshTokenException;
import com.example.authservice.model.token.RefreshTokenEntity;
import lombok.*;
import lombok.extern.slf4j.*;

@Slf4j
@RequiredArgsConstructor
public class JwtValidationService {

    private static final String RSA_ALGORITHM_FAMILY = "RSA";

    private final Algorithm algorithm;

    private final ZoneId timeZoneId;

    public static JwtValidationService of(JwtValidatorProperties jwtValidatorProperties) {
        var key = buildPublicKey(jwtValidatorProperties.publicKey(), RSA_ALGORITHM_FAMILY);
        var algorithm = Algorithm.RSA256(key, null);
        var timeZoneId = ZoneId.of(jwtValidatorProperties.zoneId());
        return new JwtValidationService(algorithm, timeZoneId);
    }

    static RSAPublicKey buildPublicKey(String publicKey, String algorithm) {
        var keyBytes = Base64.getDecoder().decode(publicKey);
        var keySpec = new X509EncodedKeySpec(keyBytes);
        try {
            var keyFactory = KeyFactory.getInstance(algorithm);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception ex) {
            throw new RuntimeException(String.format(
                "Error on building public key(%s): %s",
                algorithm, publicKey
            ), ex);
        }
    }

    public RefreshTokenEntity extractRefreshToken(String refreshToken) {
        try {
            var jwt = getDecodedJwt(refreshToken);
            var token = RefreshTokenEntity.builder()
                .id(jwt.getClaim("id").asInt())
                .userId(jwt.getClaim("user_id").asInt())
                .accessTokenJti(UUID.fromString(jwt.getClaim("access_token_jti").asString()))
                .refreshTokenJti(UUID.fromString(jwt.getId()))
                .expiredAt(jwt.getExpiresAtAsInstant().atZone(timeZoneId))
                .issuedAt(jwt.getIssuedAtAsInstant().atZone(timeZoneId))
                .build();

            return token;
        } catch (JWTVerificationException e) {
            throw new InvalidRefreshTokenException(e);
        }
    }

    public UUID extractAccessTokenJti(String accessToken) {
        try {
            var token = accessToken.substring("Bearer ".length());
            var jwt = getDecodedJwt(token);
            var jti = UUID.fromString(jwt.getId());

            return jti;
        } catch (JWTVerificationException e) {
            throw new InvalidAccessTokenException(e);
        }
    }

    private DecodedJWT getDecodedJwt(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

}
