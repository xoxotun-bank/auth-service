package com.example.authservice.controller;

import com.example.authservice.swagger.api.LoginApi;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.authservice.exception.*;
import com.example.authservice.service.*;
import com.example.authservice.swagger.api.*;
import com.example.authservice.swagger.dto.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v2/auth/")
public class LoginApiController implements LoginApi {

    private final LoginService loginService;

    @Override
    public ResponseEntity<ApiResponseDto> login(
        LoginRequestDto body
    ) {

        var user = loginService.getUserByLogin(body.getLogin());
        if (user == null) {
            throw new UserNotFoundException();
        }

        var isUserLoggedIn = loginService.checkUserCredentials(
            user.getId(),
            body.getPassword());
        if (!isUserLoggedIn) {
            throw new UserNotFoundException();
        }

        var accessTokenJti = loginService.generateJti();
        var accessToken = loginService.generateAccessToken(user, accessTokenJti);
        var refreshToken = loginService.generateRefreshToken(user.getId(), accessTokenJti);
        var flag = user.getFlagGuideShown();

        if(!flag){
            user.setFlagGuideShown(true);
            loginService.updateUser(user);
        }

        var apiResponse = new ApiResponseDto();
        apiResponse.setFlagGuideShown(flag);
        apiResponse.setAccessToken(accessToken);
        apiResponse.setRefreshToken(refreshToken);

        return ResponseEntity.ok(apiResponse);
    }

}
