package org.example.flowerapi.repository;

import org.example.flowerapi.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower,Long> {

}
