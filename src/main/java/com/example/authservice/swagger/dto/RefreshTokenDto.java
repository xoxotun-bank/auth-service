package com.example.authservice.swagger.dto;

import java.util.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.*;
import org.springframework.validation.annotation.*;

/**
 * RefreshTokenDto
 */
@Validated

public class RefreshTokenDto {

    @JsonProperty("refreshToken")
    private String refreshToken = null;

    public RefreshTokenDto refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    /**
     * Get refreshToken
     *
     * @return refreshToken
     **/
    @Schema(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyMTIzIiwiaWF0IjoxNjE5NzA4NDAwLCJleHAiOjE2MTk3OTQ4MDAsImp0aSI6ImFiYzEyM2RlZjQ1NiJ9.Ht_Ks-Ks_Ks_Ks_Ks_Ks_Ks_Ks_Ks", required = true, description = "")
    @NotNull

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefreshTokenDto refreshTokenDto = (RefreshTokenDto) o;
        return Objects.equals(this.refreshToken, refreshTokenDto.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshToken);
    }

    @Override
    public String toString() {

        String sb = "class RefreshTokenDto {\n" +
                    "    refreshToken: " + toIndentedString(refreshToken) + "\n" +
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
