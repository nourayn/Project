package com.digitalblood.donationbackend.controller;

import com.digitalblood.donationbackend.dto.DonorDTO;
import com.digitalblood.donationbackend.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
@CrossOrigin(origins = "*")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping
    public DonorDTO addDonor(@RequestBody DonorDTO donorDTO) {
        return donorService.createDonor(donorDTO);
    }

    @GetMapping
    public List<DonorDTO> getAllDonors() {
        return donorService.getAllDonors();
    }

    @GetMapping("/{id}")
    public DonorDTO getDonor(@PathVariable Long id) {
        return donorService.getDonorById(id);
    }

    @PutMapping("/{id}")
    public DonorDTO updateDonor(@PathVariable Long id, @RequestBody DonorDTO donorDTO) {
        return donorService.updateDonor(id, donorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
    }
}
