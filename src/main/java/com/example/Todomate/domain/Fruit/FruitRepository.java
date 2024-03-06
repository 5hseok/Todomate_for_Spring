package com.example.Todomate.domain.Fruit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    long countByName(String name);
    List<Fruit> findAllByName(String name);
    List<Fruit> findAllByPriceGreaterThanEqual(long price);
    List<Fruit> findAllByPriceLessThanEqual(long price);

}