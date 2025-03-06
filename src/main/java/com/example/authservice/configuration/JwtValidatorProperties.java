package com.example.authservice.configuration;

import org.springframework.boot.context.properties.*;

@ConfigurationProperties("jwt-validator-properties")
public record JwtValidatorProperties(
    String publicKey,
    String zoneId
) {

}
