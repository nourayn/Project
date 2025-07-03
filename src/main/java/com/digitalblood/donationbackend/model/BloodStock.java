package com.digitalblood.donationbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blood_stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_type", nullable = false, unique = true)
    private String bloodType;

    @Column(name = "units_available", nullable = false)
    private int unitsAvailable;
}

