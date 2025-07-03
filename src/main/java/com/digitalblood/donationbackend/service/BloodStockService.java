package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.BloodStockDTO;

import java.util.List;

public interface BloodStockService {

    BloodStockDTO createOrUpdateStock(BloodStockDTO stockDTO);

    List<BloodStockDTO> getAllStock();

    BloodStockDTO getStockByBloodType(String bloodType);

    void deleteStockById(Long id);
}
