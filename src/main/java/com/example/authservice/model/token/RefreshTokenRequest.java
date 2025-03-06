package com.example.authservice.model.token;

import java.util.*;

import lombok.*;

@Builder
@Getter
public class RefreshTokenRequest {

    private Integer userId;

    private UUID accessTokenJti;

}
