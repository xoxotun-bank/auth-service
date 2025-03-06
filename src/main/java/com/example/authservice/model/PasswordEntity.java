package com.example.authservice.model;

import jakarta.persistence.*;

import lombok.*;

@Entity(name = "passwords")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "salt")
    private String salt;

    @Column(name = "active")
    private boolean isActive;

    @Column(name = "hash")
    private String hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
