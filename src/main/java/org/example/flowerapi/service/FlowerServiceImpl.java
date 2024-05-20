package org.example.flowerapi.service;

import lombok.AllArgsConstructor;
import org.example.flowerapi.dto.FlowerDto;
import org.example.flowerapi.entity.Flower;
import org.example.flowerapi.exception.ResourceNotFoundException;
import org.example.flowerapi.mapper.FlowerMapper;
import org.example.flowerapi.repository.FlowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlowerServiceImpl implements FlowerService {

    private FlowerRepository flowerRepository;

    @Override
    public FlowerDto createFlower(FlowerDto flowerDto) {
        Flower flower = FlowerMapper.mapToFlower(flowerDto);
        Flower saveFlower = flowerRepository.save(flower);
        return FlowerMapper.mapToFloweDTo(saveFlower);
    }

    @Override
    public FlowerDto getFlowerById(Long id) {
        Flower flower = flowerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flower is not found with given ID"));
        return FlowerMapper.mapToFloweDTo(flower);
    }

    @Override
    public List<FlowerDto> getFlowerList() {
        List<Flower> flowers = flowerRepository.findAll();
        return flowers.stream().map((employee -> FlowerMapper.mapToFloweDTo(employee))).collect(Collectors.toList());

    }

    @Override
    public FlowerDto updateFlower(Long id, FlowerDto flowerDto) {
        Flower flower = flowerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flower is not found with given ID"));
        flower.setColor(flowerDto.getColor());
        flower.setName(flowerDto.getName());
        flower.setType(flowerDto.getType());
        Flower updateFlower = flowerRepository.save(flower);
        return FlowerMapper.mapToFloweDTo(updateFlower);
    }

    @Override
    public void deleteFlower(Long id) {
        Flower flower = flowerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flower is not found with given ID"));
        flowerRepository.delete(flower);
    }
}
