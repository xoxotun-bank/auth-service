package com.example.authservice.controller;

import com.example.authservice.repository.UserRepository;
import com.example.authservice.swagger.api.RefreshApi;
import com.example.authservice.swagger.dto.ApiResponseDto;
import com.example.authservice.swagger.dto.RefreshTokenDto;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v2/auth/")
public class RefreshApiController implements RefreshApi {

    private final RefreshService refreshService;

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ApiResponseDto> getNewTokens(RefreshTokenDto body) {
        var oldRefreshToken = refreshService.extractRefreshTokenEntity(body.getRefreshToken());

        var user = userRepository.findById(oldRefreshToken.getUserId())
            .orElseThrow(UserNotFoundException::new);

        var accessTokenJti = refreshService.generateJti();
        var accessToken = refreshService.generateAccessToken(user, accessTokenJti);
        var refreshToken = refreshService.reGenerateRefreshToken(
            user.getId(), oldRefreshToken.getId(), accessTokenJti);

        var apiResponseDto = new ApiResponseDto();
        apiResponseDto.setFlagGuideShown(user.getFlagGuideShown());
        apiResponseDto.setRefreshToken(refreshToken);
        apiResponseDto.setAccessToken(accessToken);

        return ResponseEntity.ok(apiResponseDto);
    }

}
