package com.example.authservice.model;

import jakarta.persistence.*;

import lombok.*;

@Entity(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

}
