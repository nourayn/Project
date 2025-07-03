package com.digitalblood.donationbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String source; // e.g., "Hospital", "System"

    private boolean read; // false = not yet read

    private LocalDateTime timestamp;
}
