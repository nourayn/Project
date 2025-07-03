package com.digitalblood.donationbackend.controller;

import com.digitalblood.donationbackend.dto.HospitalDTO;
import com.digitalblood.donationbackend.model.Hospital;
import com.digitalblood.donationbackend.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
@CrossOrigin(origins = "*")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public Hospital registerHospital(@RequestBody HospitalDTO dto) {
        return hospitalService.registerHospital(dto);
    }

    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @PutMapping("/{id}")
    public Hospital updateHospital(@PathVariable Long id, @RequestBody HospitalDTO dto) {
        return hospitalService.updateHospital(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
    }
}
