package com.example.authservice.configuration;

import com.example.authservice.repository.RefreshTokensRepository;
import com.example.authservice.service.JwtTokenGeneratorService;
import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableConfigurationProperties({JwtGeneratorProperties.class})
@RequiredArgsConstructor
public class JwtGeneratorConfiguration {

    private final JwtGeneratorProperties jwtGeneratorProperties;

    private final RefreshTokensRepository refreshTokensRepository;

    @Bean
    public JwtTokenGeneratorService jwtTokenGenerator() {
        return JwtTokenGeneratorService.of(jwtGeneratorProperties, refreshTokensRepository);
    }

}
