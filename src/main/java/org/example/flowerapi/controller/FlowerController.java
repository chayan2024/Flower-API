package org.example.flowerapi.controller;

import lombok.AllArgsConstructor;
import org.example.flowerapi.dto.FlowerDto;
import org.example.flowerapi.entity.Flower;
import org.example.flowerapi.exception.ResourceNotFoundException;
import org.example.flowerapi.service.FlowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/flowercrud")
public class FlowerController {
    private final FlowerService flowerService;

    @PostMapping
    public ResponseEntity<FlowerDto> createFlower(@RequestBody FlowerDto flowerDto) {
       FlowerDto flowers=flowerService.createFlower(flowerDto);
       return ResponseEntity.ok(flowers);
    }

    @GetMapping("{id}")
    public ResponseEntity<FlowerDto> getFlowerById(@PathVariable("id") Long flowerId) {
        FlowerDto flowers=flowerService.getFlowerById(flowerId);
        return ResponseEntity.ok(flowers);
    }

    @GetMapping
    public ResponseEntity<List<FlowerDto>> getAllFlowers() {
        List<FlowerDto> flowers=flowerService.getFlowerList();
        return ResponseEntity.ok(flowers);
    }

    @PutMapping("{id}")
    public ResponseEntity<FlowerDto> updateFlower(@PathVariable("id") Long id,@RequestBody FlowerDto flowerDto) {
        flowerService.updateFlower(id,flowerDto);
        return ResponseEntity.ok(flowerDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFlower(@PathVariable("id") Long flowerId) {
        flowerService.deleteFlower(flowerId);
        return ResponseEntity.ok("Flower deleted");
    }

}
