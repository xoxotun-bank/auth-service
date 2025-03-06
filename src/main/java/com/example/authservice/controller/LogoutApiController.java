package com.example.authservice.controller;

import com.example.authservice.swagger.api.LogoutApi;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.authservice.service.*;
import com.example.authservice.swagger.api.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v2/auth/")
public class LogoutApiController implements LogoutApi {

    private final LogoutService logoutService;

    @Override
    public ResponseEntity<Void> logout(
        String accessToken
    ) {
        logoutService.logout(accessToken);
        return ResponseEntity.ok().build();
    }

}
