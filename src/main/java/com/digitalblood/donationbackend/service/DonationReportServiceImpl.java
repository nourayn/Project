package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.DonationReportDTO;
import com.digitalblood.donationbackend.model.DonationReport;
import com.digitalblood.donationbackend.repository.DonationReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationReportServiceImpl implements DonationReportService {

    @Autowired
    private DonationReportRepository repository;

    private DonationReportDTO convertToDTO(DonationReport report) {
        return new DonationReportDTO(
                report.getId(),
                report.getDonorName(),
                report.getBloodType(),
                report.getHospitalName(),
                report.getDonationDate(),
                report.getDonorAge(),
                report.getDonorWeight()
        );
    }

    private DonationReport convertToEntity(DonationReportDTO dto) {
        return new DonationReport(
                dto.getId(),
                dto.getDonorName(),
                dto.getBloodType(),
                dto.getHospitalName(),
                dto.getDonationDate(),
                dto.getDonorAge(),
                dto.getDonorWeight()
        );
    }

    @Override
    public DonationReportDTO create(DonationReportDTO dto) {
        DonationReport saved = repository.save(convertToEntity(dto));
        return convertToDTO(saved);
    }

    @Override
    public DonationReportDTO update(Long id, DonationReportDTO dto) {
        DonationReport existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        existing.setDonorName(dto.getDonorName());
        existing.setBloodType(dto.getBloodType());
        existing.setHospitalName(dto.getHospitalName());
        existing.setDonationDate(dto.getDonationDate());
        existing.setDonorAge(dto.getDonorAge());
        existing.setDonorWeight(dto.getDonorWeight());

        return convertToDTO(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DonationReportDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DonationReportDTO getById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }
}
