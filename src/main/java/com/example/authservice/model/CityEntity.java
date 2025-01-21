package com.example.authservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

}
