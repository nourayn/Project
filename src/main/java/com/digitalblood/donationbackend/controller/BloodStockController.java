package com.digitalblood.donationbackend.controller;

import com.digitalblood.donationbackend.dto.BloodStockDTO;
import com.digitalblood.donationbackend.service.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodstock")
@CrossOrigin(origins = "*")  // Allow all origins, adjust if needed for security
public class BloodStockController {

    @Autowired
    private BloodStockService bloodStockService;

    @PostMapping
    public ResponseEntity<BloodStockDTO> createOrUpdateStock(@RequestBody BloodStockDTO stockDTO) {
        BloodStockDTO savedStock = bloodStockService.createOrUpdateStock(stockDTO);
        return ResponseEntity.ok(savedStock);
    }

    @GetMapping
    public ResponseEntity<List<BloodStockDTO>> getAllStock() {
        List<BloodStockDTO> stockList = bloodStockService.getAllStock();
        return ResponseEntity.ok(stockList);
    }

    @GetMapping("/{bloodType}")
    public ResponseEntity<BloodStockDTO> getStockByBloodType(@PathVariable String bloodType) {
        BloodStockDTO stock = bloodStockService.getStockByBloodType(bloodType);
        return ResponseEntity.ok(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        bloodStockService.deleteStockById(id);
        return ResponseEntity.noContent().build();
    }
}
