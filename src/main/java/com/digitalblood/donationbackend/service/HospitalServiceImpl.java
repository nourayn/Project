package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.HospitalDTO;
import com.digitalblood.donationbackend.model.Hospital;
import com.digitalblood.donationbackend.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Hospital registerHospital(HospitalDTO dto) {
        Hospital hospital = new Hospital(
                dto.getHospitalName(),
                dto.getAddress(),
                dto.getPhoneNumber(),
                dto.getEmail(),
                dto.isApproved()
        );
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital updateHospital(Long id, HospitalDTO dto) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            hospital.setHospitalName(dto.getHospitalName());
            hospital.setAddress(dto.getAddress());
            hospital.setPhoneNumber(dto.getPhoneNumber());
            hospital.setEmail(dto.getEmail());
            hospital.setApproved(dto.isApproved());
            return hospitalRepository.save(hospital);
        } else {
            throw new RuntimeException("Hospital not found with ID: " + id);
        }
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }
}
