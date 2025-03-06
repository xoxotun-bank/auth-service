package com.example.authservice.configuration;

import org.modelmapper.*;
import org.modelmapper.convention.*;
import org.springframework.context.annotation.*;

import static org.modelmapper.config.Configuration.AccessLevel.*;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        mapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(PRIVATE)
            .setSkipNullEnabled(true);
        return mapper;
    }

}
