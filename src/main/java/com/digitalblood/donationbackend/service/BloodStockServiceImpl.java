package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.BloodStockDTO;
import com.digitalblood.donationbackend.model.BloodStock;
import com.digitalblood.donationbackend.repository.BloodStockRepository;
import com.digitalblood.donationbackend.service.BloodStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodStockServiceImpl implements BloodStockService {

    private final BloodStockRepository bloodStockRepository;

    @Override
    public BloodStockDTO createOrUpdateStock(BloodStockDTO stockDTO) {
        Optional<BloodStock> existingStock = bloodStockRepository.findByBloodType(stockDTO.getBloodType());

        BloodStock stock = existingStock.orElse(new BloodStock());
        stock.setBloodType(stockDTO.getBloodType());
        stock.setUnitsAvailable(stockDTO.getUnitsAvailable());

        BloodStock saved = bloodStockRepository.save(stock);
        return mapToDTO(saved);
    }

    @Override
    public List<BloodStockDTO> getAllStock() {
        return bloodStockRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BloodStockDTO getStockByBloodType(String bloodType) {
        BloodStock stock = bloodStockRepository.findByBloodType(bloodType)
                .orElseThrow(() -> new RuntimeException("Blood type not found: " + bloodType));
        return mapToDTO(stock);
    }

    @Override
    public void deleteStockById(Long id) {
        bloodStockRepository.deleteById(id);
    }

    // Helper method to convert Entity -> DTO
    private BloodStockDTO mapToDTO(BloodStock stock) {
        return new BloodStockDTO(
                stock.getId(),
                stock.getBloodType(),
                stock.getUnitsAvailable()
        );
    }
}
