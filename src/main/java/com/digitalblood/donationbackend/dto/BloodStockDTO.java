package com.digitalblood.donationbackend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodStockDTO {
    private Long id;
    private String bloodType;
    private int unitsAvailable;
}
