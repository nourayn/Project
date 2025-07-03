package com.digitalblood.donationbackend.repository;

import com.digitalblood.donationbackend.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    boolean existsByEmail(String email);
}
