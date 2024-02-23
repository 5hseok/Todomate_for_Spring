package com.example.Todomate.repository.Fruit;

import com.example.Todomate.domain.Fruit.Fruit;
import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.response.FruitResponse;

import java.util.List;

public interface FruitRepository {
    void saveFruit(FruitRequest fruitRequest);
    FruitResponse getFruit(String name);
    void putFruit(long id);
    boolean isNotFruitExist(long id);
}
