package com.example.Todomate.service.Fruit;

import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.response.FruitResponse;
import com.example.Todomate.repository.Fruit.FruitRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class FruitJdbcService {
    private final FruitRepository fruitRepository;

    public FruitJdbcService(@Qualifier("SQL") FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitRequest fruitRequest){
        if (fruitRequest.getName() == null || fruitRequest.getWarehousingDate() == null) {
            throw new IllegalArgumentException();
        }
        fruitRepository.saveFruit(fruitRequest);
    }

    public FruitResponse getFruit(String name){
        return fruitRepository.getFruit(name);
    }
    public void putFruit(long id){
        if(fruitRepository.isNotFruitExist(id)){
            throw new IllegalArgumentException();
        }
        fruitRepository.putFruit(id);
    }
}
