package org.example.flowerapi.mapper;

import org.example.flowerapi.dto.FlowerDto;
import org.example.flowerapi.entity.Flower;

public class FlowerMapper {

    public static FlowerDto mapToFloweDTo(Flower flower) {
        return new FlowerDto(flower.getId(), flower.getName(), flower.getType(), flower.getColor());
    }

    public static Flower mapToFlower(FlowerDto flowerDto) {
        return new Flower(flowerDto.getId(), flowerDto.getName(), flowerDto.getType(), flowerDto.getColor());
    }
}
