package com.example.authservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.*;

@ConfigurationProperties("jwt-generator-properties")
public record JwtGeneratorProperties(
    String privateKey,
    Integer accessTokenExpiredOnSeconds,
    Integer refreshTokenExpiredOnSeconds,
    String zoneId) {

}
