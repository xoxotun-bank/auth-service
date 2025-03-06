package com.example.authservice.exception;

import org.springframework.http.*;

public class InvalidAccessTokenException extends DefaultException {

    private static final String INVALID_ACCESS_TOKEN = "AccessToken не валиден";

    private static final int INVALID_ACCESS_TOKEN_CODE = 1002;

    private static final HttpStatus INVALID_ACCESS_TOKEN_STATUS = HttpStatus.UNAUTHORIZED;

    public InvalidAccessTokenException() {
        super(INVALID_ACCESS_TOKEN, INVALID_ACCESS_TOKEN_CODE, INVALID_ACCESS_TOKEN_STATUS);
    }

    public InvalidAccessTokenException(
        Throwable cause
    ) {
        super(INVALID_ACCESS_TOKEN, INVALID_ACCESS_TOKEN_CODE, INVALID_ACCESS_TOKEN_STATUS, cause);
    }

}
