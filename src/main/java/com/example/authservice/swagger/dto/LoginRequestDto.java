package com.example.authservice.swagger.dto;

import java.util.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.*;
import org.springframework.validation.annotation.*;

/**
 * LoginRequestDto
 */
@Validated

public class LoginRequestDto {

    @JsonProperty("login")
    private String login = null;

    @JsonProperty("password")
    private String password = null;

    public LoginRequestDto login(String login) {
        this.login = login;
        return this;
    }

    /**
     * Get login
     *
     * @return login
     **/
    @Schema(example = "drazdobarov", required = true, description = "")
    @NotNull

    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LoginRequestDto password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     **/
    @Schema(example = "dWEdsafa09we8ew", required = true, description = "")
    @NotNull

    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoginRequestDto loginRequestDto = (LoginRequestDto) o;
        return Objects.equals(this.login, loginRequestDto.login) &&
               Objects.equals(this.password, loginRequestDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {

        String sb = "class LoginRequestDto {\n" +
                    "    login: " + toIndentedString(login) + "\n" +
                    "    password: " + toIndentedString(password) + "\n" +
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
