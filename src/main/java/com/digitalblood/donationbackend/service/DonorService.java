package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.DonorDTO;

import java.util.List;

public interface DonorService {
    DonorDTO createDonor(DonorDTO donorDTO);
    List<DonorDTO> getAllDonors();
    DonorDTO getDonorById(Long id);
    DonorDTO updateDonor(Long id, DonorDTO donorDTO);
    void deleteDonor(Long id);
}
