package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.DonationReportDTO;

import java.util.List;

public interface DonationReportService {
    DonationReportDTO create(DonationReportDTO dto);
    DonationReportDTO update(Long id, DonationReportDTO dto);
    void delete(Long id);
    List<DonationReportDTO> getAll();
    DonationReportDTO getById(Long id);
}
