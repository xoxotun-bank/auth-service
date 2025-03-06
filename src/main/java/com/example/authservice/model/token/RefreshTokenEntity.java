package com.example.authservice.model.token;

import java.time.*;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "refresh_tokens")
public class RefreshTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "access_token_jti")
    private UUID accessTokenJti;

    @Column(name = "refresh_token_jti")
    private UUID refreshTokenJti;

    @Column(name = "expiration_date")
    private ZonedDateTime expiredAt;

    @Column(name = "issued_at")
    private ZonedDateTime issuedAt;

}
