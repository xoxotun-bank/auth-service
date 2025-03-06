package com.example.authservice.configuration;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.version}")
    private String version;

    @Bean
    public OpenAPI openAPI() {
        var info = new Info()
            .title("МКС Auth API")
            .version(version)
            .description("API for authentication");
        return new OpenAPI()
            .info(info);
    }

}
