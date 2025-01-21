package com.example.authservice.swagger.dto;

import java.util.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.*;
import org.springframework.validation.annotation.*;

/**
 * ApiResponseDto
 */
@Validated

public class ApiResponseDto {

    @JsonProperty("accessToken")
    private String accessToken = null;

    @JsonProperty("refreshToken")
    private String refreshToken = null;

    @JsonProperty("flagGuideShown")
    private Boolean flagGuideShown = null;

    public ApiResponseDto accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * Get accessToken
     *
     * @return accessToken
     **/
    @Schema(example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJyb2xlcyI6WyJvcGVyYXRvciJdLCJleHAiOjIwMTU3NTAyMzMsImlhdCI6MTcxNTc1MDIzM30.cb-NJLdr0KKHbh5Eijvk3PBepXAOala_9XeAJMQMLXwJz_i7L4cxmrKEvf0iT3HWjxSEQGbaazEFFXNp1_pQd8EHgWRmk9W6Mzjc8v7rO2_nIWd-oukO4OBDSWJ-q3i3yWhypryD3pYF_-WxISNcztrRNAPl6rq-jIodoz3AzC18NI4RDZ6MsPMyw71XhETfu6T81fS7GcV9XDr41KSFJCn0fdZTg9HFcC28HiYjnvu3VG5CnTRLJNwkcEdm3CE8Cqr2xM2M17NbWWxWdYCMPkVDqiF8hI-JJwLndYJCNpq2rfDYk8ei8cRHVeD8QYsW01ntaffOFXCX0rC1gPI8Cw", required = true, description = "")
    @NotNull

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ApiResponseDto refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    /**
     * Get refreshToken
     *
     * @return refreshToken
     **/
    @Schema(example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJqd3RfaWQiOiJhNzY2MDJiOC03MmZkLTQ0OTEtYTNiNy1kYjJkYWNkMDBhZGMiLCJleHAiOjIwMTU3NDk5MDksImlhdCI6MTcxNTc0OTkwOX0.dj-NMVEJ8BhgzPhLybNJ92_s-rStCIM1yphL40lc3Zb8MMeSK7q6lvWZL9jYlSrN_hfLEiMutVmTtv6pInQ-iclNheo_K3--qWaRQhk3ROVoDbUhFXOeI6cksUlx7UDtxzzCJ5UjPSK-fjBrZTL8d0iMoHyNBmGVuyCcCHluyGAgr0kNWmmd6nJFoHE46Nq4MNsNH_vw66cFFoFtTu10d-QiZb6_UFMCcLfushDyjccprjTDeBMpw3oy_HUNnEfr3P_JYWXQMEm8oEcRfrmWyK3uXo2nyfmn1iLT-ArxiDUHq2s-syeSl9LBT9c4K2bq7hYqzRxSZUmQppGIb_CKng", required = true, description = "")
    @NotNull

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public ApiResponseDto flagGuideShown(Boolean flagGuideShown) {
        this.flagGuideShown = flagGuideShown;
        return this;
    }

    /**
     * Get flagGuideShown
     *
     * @return flagGuideShown
     **/
    @Schema(example = "false", required = true, description = "")
    @NotNull

    public Boolean isFlagGuideShown() {
        return flagGuideShown;
    }

    public void setFlagGuideShown(Boolean flagGuideShown) {
        this.flagGuideShown = flagGuideShown;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiResponseDto apiResponseDto = (ApiResponseDto) o;
        return Objects.equals(this.accessToken, apiResponseDto.accessToken) &&
               Objects.equals(this.refreshToken, apiResponseDto.refreshToken) &&
               Objects.equals(this.flagGuideShown, apiResponseDto.flagGuideShown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, refreshToken, flagGuideShown);
    }

    @Override
    public String toString() {

        String sb = "class ApiResponseDto {\n" +
                    "    accessToken: " + toIndentedString(accessToken) + "\n" +
                    "    refreshToken: " + toIndentedString(refreshToken) + "\n" +
                    "    flagGuideShown: " + toIndentedString(flagGuideShown) + "\n" +
                    "}";
        return sb;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
