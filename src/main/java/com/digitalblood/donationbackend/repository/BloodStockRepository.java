package com.digitalblood.donationbackend.repository;

import com.digitalblood.donationbackend.model.BloodStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodStockRepository extends JpaRepository<BloodStock, Long> {
    Optional<BloodStock> findByBloodType(String bloodType);
}
