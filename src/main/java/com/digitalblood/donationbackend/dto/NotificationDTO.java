package com.digitalblood.donationbackend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Long id;
    private String message;
    private String source;
    private boolean read;
    private LocalDateTime timestamp;
}
