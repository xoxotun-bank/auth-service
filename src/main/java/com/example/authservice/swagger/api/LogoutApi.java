/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.56).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

package com.example.authservice.swagger.api;

import java.util.*;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.*;

import com.fasterxml.jackson.databind.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.enums.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.authservice.swagger.dto.*;

@Validated
public interface LogoutApi {

    Logger log = LoggerFactory.getLogger(LogoutApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Метод выхода из учетной записи пользователя", description = "", tags = {"Auth"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Успешный выход из учетной записи"),

        @ApiResponse(responseCode = "400", description = "Данные не валидны", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))),

        @ApiResponse(responseCode = "401", description = "Не авторизован пользователь", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))),

        @ApiResponse(responseCode = "5XX", description = "Ошибка на стороне сервера.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class)))})
    @RequestMapping(value = "/logout",
        produces = {"application/json"},
        method = RequestMethod.POST)
    default ResponseEntity<Void> logout(
        @Parameter(in = ParameterIn.HEADER, description = "", required = true, schema = @Schema()) @RequestHeader(value = "Authorization", required = true) String authorization
    ) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn(
                "ObjectMapper or HttpServletRequest not configured in default LogoutApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

