package com.example.Todomate.controller.fruit;

import com.example.Todomate.dto.fruit.request.FruitRequest;
import com.example.Todomate.dto.fruit.request.FruitUpdateRequest;
import com.example.Todomate.dto.fruit.response.FruitResponse;
import com.example.Todomate.service.Fruit.FruitService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request){
        fruitService.saveFruit(request);
    }

    @GetMapping("api/v1/fruit/stat")
    public FruitResponse getFruitTotalPrice(@RequestParam String name){
        return fruitService.getFruit(name);
    }

    @PutMapping("api/v1/fruit")
    public void putFruit(@RequestBody FruitUpdateRequest request){
        fruitService.putFruit(request.getId());
    }

}

