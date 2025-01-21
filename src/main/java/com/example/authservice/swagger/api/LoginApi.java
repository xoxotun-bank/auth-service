/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.56).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

package com.example.authservice.swagger.api;

import java.io.*;
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


@Validated
public interface LoginApi {

    Logger log = LoggerFactory.getLogger(LoginApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Метод аутентификации пользователя", description = "", tags = {"Auth"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Успешная аутентификация", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class))),

        @ApiResponse(responseCode = "400", description = "Данные не валидны", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))),

        @ApiResponse(responseCode = "404", description = "Пользователь не найден", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))),

        @ApiResponse(responseCode = "5XX", description = "Ошибка на стороне сервера.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class)))})
    @RequestMapping(value = "/login",
        produces = {"application/json"},
        consumes = {"application/json;charset=UTF-8"},
        method = RequestMethod.POST)
    default ResponseEntity<ApiResponseDto> login(
        @Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody LoginRequestDto body
    ) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get()
                        .readValue(
                            "{\r\n  \"flagGuideShown\" : false,\r\n  \"login\" : \"drazdobarov\",\r\n  \"accessToken\" : \"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJyb2xlcyI6WyJvcGVyYXRvciJdLCJleHAiOjIwMTU3NTAyMzMsImlhdCI6MTcxNTc1MDIzM30.cb-NJLdr0KKHbh5Eijvk3PBepXAOala_9XeAJMQMLXwJz_i7L4cxmrKEvf0iT3HWjxSEQGbaazEFFXNp1_pQd8EHgWRmk9W6Mzjc8v7rO2_nIWd-oukO4OBDSWJ-q3i3yWhypryD3pYF_-WxISNcztrRNAPl6rq-jIodoz3AzC18NI4RDZ6MsPMyw71XhETfu6T81fS7GcV9XDr41KSFJCn0fdZTg9HFcC28HiYjnvu3VG5CnTRLJNwkcEdm3CE8Cqr2xM2M17NbWWxWdYCMPkVDqiF8hI-JJwLndYJCNpq2rfDYk8ei8cRHVeD8QYsW01ntaffOFXCX0rC1gPI8Cw\",\r\n  \"refreshToken\" : \"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJqd3RfaWQiOiJhNzY2MDJiOC03MmZkLTQ0OTEtYTNiNy1kYjJkYWNkMDBhZGMiLCJleHAiOjIwMTU3NDk5MDksImlhdCI6MTcxNTc0OTkwOX0.dj-NMVEJ8BhgzPhLybNJ92_s-rStCIM1yphL40lc3Zb8MMeSK7q6lvWZL9jYlSrN_hfLEiMutVmTtv6pInQ-iclNheo_K3--qWaRQhk3ROVoDbUhFXOeI6cksUlx7UDtxzzCJ5UjPSK-fjBrZTL8d0iMoHyNBmGVuyCcCHluyGAgr0kNWmmd6nJFoHE46Nq4MNsNH_vw66cFFoFtTu10d-QiZb6_UFMCcLfushDyjccprjTDeBMpw3oy_HUNnEfr3P_JYWXQMEm8oEcRfrmWyK3uXo2nyfmn1iLT-ArxiDUHq2s-syeSl9LBT9c4K2bq7hYqzRxSZUmQppGIb_CKng\"\r\n}",
                            ApiResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn(
                "ObjectMapper or HttpServletRequest not configured in default LoginApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

