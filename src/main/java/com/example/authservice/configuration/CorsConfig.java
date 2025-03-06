package com.example.authservice.configuration;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig {

    @Value("${cors.allowed-origins}")
    private String[] allowedOrigins;

    @Value("${cors.allowed-headers}")
    private String[] allowedHeaders;

    @Value("${cors.allowed-methods}")
    private String[] allowedMethods;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins(allowedOrigins)
                    .allowedHeaders(allowedHeaders)
                    .allowedMethods(allowedMethods);
            }
        };
    }

}
