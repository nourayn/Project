package com.digitalblood.donationbackend.controller;

import com.digitalblood.donationbackend.dto.DonationReportDTO;
import com.digitalblood.donationbackend.service.DonationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class DonationReportController {

    @Autowired
    private DonationReportService service;

    @PostMapping
    public DonationReportDTO create(@RequestBody DonationReportDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<DonationReportDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DonationReportDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public DonationReportDTO update(@PathVariable Long id, @RequestBody DonationReportDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
