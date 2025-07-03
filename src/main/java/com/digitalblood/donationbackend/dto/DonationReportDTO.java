package com.digitalblood.donationbackend.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationReportDTO {

    private Long id;
    private String donorName;
    private String bloodType;
    private String hospitalName;
    private LocalDate donationDate;
    private int donorAge;
    private double donorWeight;
}
