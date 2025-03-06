package com.example.authservice.exception;

import com.example.authservice.swagger.dto.ApiErrorResponseDto;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_SERVER = "Внутренняя ошибка сервера или базы данных";

    private static final String ERROR_VALIDATION_NULL =
        "Ошибка запроса,  отсутствуют следующие параметры запроса:";

    private static final String ERROR_VALIDATION_PATTERN =
        "Ошибка запроса,  некорректные данные в следующих параметрах:";

    private static final int ERROR_VALIDATION_NULL_CODE = 1004;

    private static final int ERROR_VALIDATION_PATTERN_CODE = 1005;

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<ApiErrorResponseDto> handleDefaultException(DefaultException e) {
        log.error("Unexpected exception", e);
        ApiErrorResponseDto apiErrorResponseDto = new ApiErrorResponseDto();
        apiErrorResponseDto.setMessage(e.getMessage());
        apiErrorResponseDto.setCode(e.getApiCode());
        return ResponseEntity.status(e.getHttpStatus()).body(apiErrorResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponseDto> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e
    ) {
        log.error("Unexpected exception", e);
        ApiErrorResponseDto apiErrorResponseDto = getValidationErrorResponse(e.getBindingResult());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(apiErrorResponseDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponseDto> handleRuntimeException(RuntimeException e) {
        log.error("Unexpected exception", e);
        ApiErrorResponseDto apiErrorResponseDto = new ApiErrorResponseDto();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        apiErrorResponseDto.setMessage(ERROR_SERVER);
        apiErrorResponseDto.setCode(status.value());
        return ResponseEntity.status(status).body(apiErrorResponseDto);
    }

    private ApiErrorResponseDto getValidationErrorResponse(BindingResult bindingResult) {
        var stringBuilder = new StringBuilder();
        var errors = bindingResult.getFieldErrors();
        var nullFields = errors.stream().filter(e -> e.getCode().equals("NotNull")).toList();
        var apiErrorResponseDto = new ApiErrorResponseDto();
        if (!nullFields.isEmpty()) {
            apiErrorResponseDto.setCode(ERROR_VALIDATION_NULL_CODE);
            stringBuilder.append(ERROR_VALIDATION_NULL);
            nullFields.forEach(fieldError ->
                stringBuilder.append(String.format(" %s,", fieldError.getField()))
            );
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
            apiErrorResponseDto.setCode(ERROR_VALIDATION_PATTERN_CODE);
            var invalidFields = bindingResult.getFieldErrors()
                .stream()
                .filter(e -> e.getCode().equals("Pattern"))
                .toList();
            if (!invalidFields.isEmpty()) {
                stringBuilder.append(ERROR_VALIDATION_PATTERN);
                invalidFields.forEach(fieldError ->
                    stringBuilder.append(String.format(
                        " %s - %s,",
                        fieldError.getField(),
                        fieldError.getRejectedValue()))
                );
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        apiErrorResponseDto.setMessage(stringBuilder.toString());
        return apiErrorResponseDto;
    }

}
