package com.example.Todomate.controller.fruit;

import com.example.Todomate.domain.Fruit.Fruit;
import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.request.FruitUpdateRequest;
import com.example.Todomate.dto.fruit.response.FruitCountResponse;
import com.example.Todomate.dto.fruit.response.FruitListResponse;
import com.example.Todomate.dto.fruit.response.FruitResponse;
import com.example.Todomate.service.Fruit.FruitJpaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {
    private final FruitJpaService fruitJpaService;

    public FruitController(FruitJpaService fruitJpaService) {
        this.fruitJpaService = fruitJpaService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request){
        fruitJpaService.saveFruit(request);
    }

    @GetMapping("api/v1/fruit/stat")
    public FruitResponse getFruitTotalPrice(@RequestParam String name){
        return fruitJpaService.getFruit(name);
    }

    @PutMapping("api/v1/fruit")
    public void putFruit(@RequestBody FruitUpdateRequest request){
        fruitJpaService.putFruit(request.getId());
    }

    @GetMapping("api/v1/fruit/count")
    public FruitCountResponse countFruit(@RequestParam String name){
        FruitCountResponse fruitCountResponse = new FruitCountResponse(fruitJpaService.countFruit(name));
        return fruitCountResponse;
    }

    @GetMapping("api/v1/fruit/list")
    public List<FruitListResponse> listFruit(@RequestParam String option, @RequestParam long price){
            return fruitJpaService.countNotSellFruit(option, price);
    }
}

