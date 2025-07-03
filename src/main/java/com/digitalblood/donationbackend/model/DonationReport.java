package com.digitalblood.donationbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String donorName;
    private String bloodType;
    private String hospitalName;
    private LocalDate donationDate;

    private int donorAge;
    private double donorWeight;
}
