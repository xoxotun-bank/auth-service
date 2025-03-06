package com.example.authservice.service;

import java.util.*;

import com.example.authservice.model.UserEntity;
import com.example.authservice.model.RoleEntity;
import com.example.authservice.model.token.AccessToken;
import com.example.authservice.model.token.RefreshTokenEntity;
import com.example.authservice.repository.RefreshTokensRepository;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@RequiredArgsConstructor
@Service
public class RefreshService {

    private final JwtValidationService jwtValidationService;

    private final RefreshTokensRepository refreshTokensRepository;

    private final JwtTokenGeneratorService jwtTokenGeneratorService;

    @Transactional
    public String reGenerateRefreshToken(
        int userId,
        int refreshTokenId,
        UUID accessTokenJti
    ) {
        refreshTokensRepository.deleteById(refreshTokenId);
        var newRefreshTokenEntity = jwtTokenGeneratorService.createRefreshTokenEntity(
            userId, accessTokenJti);
        return jwtTokenGeneratorService.generateRefreshToken(newRefreshTokenEntity);
    }

    public String generateAccessToken(UserEntity user, UUID jti) {
        var roles = user.getRoles().stream()
            .map(RoleEntity::getName)
            .toList();
        var accessTokenEntity = AccessToken.builder()
            .roles(roles)
            .userId(user.getId())
            .city(user.getCity().getCity())
            .region(user.getCity().getRegion())
            .jti(jti)
            .build();
        var accessToken = jwtTokenGeneratorService.generateAccessToken(accessTokenEntity);
        return accessToken;
    }

    public UUID generateJti() {
        return UUID.randomUUID();
    }

    public RefreshTokenEntity extractRefreshTokenEntity(String refreshToken) {
        return jwtValidationService.extractRefreshToken(refreshToken);
    }

}
