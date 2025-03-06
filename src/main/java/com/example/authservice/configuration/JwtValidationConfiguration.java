package com.example.authservice.configuration;

import com.example.authservice.service.JwtValidationService;
import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableConfigurationProperties({JwtValidatorProperties.class})
@RequiredArgsConstructor
public class JwtValidationConfiguration {

    private final JwtValidatorProperties jwtValidatorProperties;

    @Bean
    JwtValidationService jwtValidationService() {
        return JwtValidationService.of(jwtValidatorProperties);
    }

}
