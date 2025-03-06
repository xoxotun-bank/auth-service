package com.example.authservice.model.token;

import java.util.*;

import lombok.*;

@Builder
@Getter
public class AccessToken {

    private List<String> roles;

    private String city;

    private String region;

    private Integer userId;

    private UUID jti;

    public List<String> getRoles() {
        return roles;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public Integer getUserId() {
        return userId;
    }

    public UUID getJti() {
        return jti;
    }
}
