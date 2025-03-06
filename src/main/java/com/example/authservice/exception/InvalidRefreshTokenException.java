package com.example.authservice.exception;

import org.springframework.http.*;

public class InvalidRefreshTokenException extends DefaultException {

    private static final String INVALID_REFRESH_TOKEN = "RefreshToken не валиден";

    private static final int INVALID_REFRESH_TOKEN_CODE = 1003;

    private static final HttpStatus INVALID_REFRESH_TOKEN_STATUS = HttpStatus.UNAUTHORIZED;

    public InvalidRefreshTokenException() {
        super(INVALID_REFRESH_TOKEN, INVALID_REFRESH_TOKEN_CODE, INVALID_REFRESH_TOKEN_STATUS);
    }

    public InvalidRefreshTokenException(
        Throwable cause
    ) {
        super(
            INVALID_REFRESH_TOKEN,
            INVALID_REFRESH_TOKEN_CODE,
            INVALID_REFRESH_TOKEN_STATUS,
            cause);
    }

}
