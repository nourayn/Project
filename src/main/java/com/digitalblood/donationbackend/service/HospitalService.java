package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.HospitalDTO;
import com.digitalblood.donationbackend.model.Hospital;

import java.util.List;

public interface HospitalService {
    Hospital registerHospital(HospitalDTO hospitalDTO);
    List<Hospital> getAllHospitals();
    Hospital updateHospital(Long id, HospitalDTO hospitalDTO);
    void deleteHospital(Long id);
}
