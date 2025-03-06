package com.example.authservice.exception;

import org.springframework.http.*;

public class UserNotFoundException extends DefaultException {

    private static final int USER_NOT_FOUND_CODE = 1001;

    private static final String ERROR_USER_NOT_FOUND = "Пользователь не найден";

    private static final HttpStatus USER_NOT_FOUND_STATUS = HttpStatus.NOT_FOUND;

    public UserNotFoundException() {
        super(ERROR_USER_NOT_FOUND, USER_NOT_FOUND_CODE, USER_NOT_FOUND_STATUS);
    }

    public UserNotFoundException(final Throwable cause) {
        super(ERROR_USER_NOT_FOUND, USER_NOT_FOUND_CODE, USER_NOT_FOUND_STATUS, cause);
    }

}
