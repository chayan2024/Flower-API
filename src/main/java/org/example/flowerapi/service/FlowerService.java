package org.example.flowerapi.service;

import org.example.flowerapi.dto.FlowerDto;

import java.util.List;

public interface FlowerService {

    FlowerDto createFlower(FlowerDto flowerDto);
    FlowerDto getFlowerById(Long id);
    List<FlowerDto> getFlowerList();
    FlowerDto updateFlower(Long id, FlowerDto flowerDto);
    void deleteFlower(Long id);

}
