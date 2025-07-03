package com.digitalblood.donationbackend.repository;

import com.digitalblood.donationbackend.model.DonationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationReportRepository extends JpaRepository<DonationReport, Long> {
}
