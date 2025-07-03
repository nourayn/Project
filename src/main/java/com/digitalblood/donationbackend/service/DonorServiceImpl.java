package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.DonorDTO;
import com.digitalblood.donationbackend.model.Donor;
import com.digitalblood.donationbackend.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    private DonorDTO mapToDTO(Donor donor) {
        return new DonorDTO(
                donor.getFullName(),
                donor.getAge(),
                donor.getWeight(),
                donor.getBloodType(),
                donor.getGender(),
                donor.getContactNumber(),
                donor.isEligible(),
                donor.getLastDonationDate()
        );
    }

    private Donor mapToEntity(DonorDTO dto) {
        return new Donor(
                dto.getFullName(),
                dto.getAge(),
                dto.getWeight(),
                dto.getBloodType(),
                dto.getGender(),
                dto.getContactNumber(),
                dto.isEligible(),
                dto.getLastDonationDate()
        );
    }

    @Override
    public DonorDTO createDonor(DonorDTO donorDTO) {
        Donor donor = mapToEntity(donorDTO);
        return mapToDTO(donorRepository.save(donor));
    }

    @Override
    public List<DonorDTO> getAllDonors() {
        return donorRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DonorDTO getDonorById(Long id) {
        return donorRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Donor not found"));
    }

    @Override
    public DonorDTO updateDonor(Long id, DonorDTO donorDTO) {
        Donor donor = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found"));

        donor.setFullName(donorDTO.getFullName());
        donor.setAge(donorDTO.getAge());
        donor.setWeight(donorDTO.getWeight());
        donor.setBloodType(donorDTO.getBloodType());
        donor.setGender(donorDTO.getGender());
        donor.setContactNumber(donorDTO.getContactNumber());
        donor.setEligible(donorDTO.isEligible());
        donor.setLastDonationDate(donorDTO.getLastDonationDate());

        return mapToDTO(donorRepository.save(donor));
    }

    @Override
    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }
}
