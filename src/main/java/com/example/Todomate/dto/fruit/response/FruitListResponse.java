package com.example.Todomate.dto.fruit.response;

import com.example.Todomate.domain.Fruit.Fruit;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class FruitListResponse {
    private String name;
    private long price;
    private LocalDate warehousingDate;

    public FruitListResponse(Fruit fruit) {
        this.name = fruit.getName();
        this.price = fruit.getPrice();
        this.warehousingDate = fruit.getWarehousingDate();
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
