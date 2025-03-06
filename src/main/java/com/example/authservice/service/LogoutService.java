package com.example.authservice.service;

import com.example.authservice.repository.RefreshTokensRepository;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final JwtValidationService jwtValidationService;

    private final RefreshTokensRepository refreshTokensRepository;

    public void logout(String accessToken) {
        var jti = jwtValidationService.extractAccessTokenJti(accessToken);
        var refreshTokenEntity = refreshTokensRepository.findByAccessTokenJti(jti)
            .orElseThrow(() -> new RuntimeException("Refresh token not found"));
        refreshTokensRepository.deleteById(refreshTokenEntity.getId());

    }

}
