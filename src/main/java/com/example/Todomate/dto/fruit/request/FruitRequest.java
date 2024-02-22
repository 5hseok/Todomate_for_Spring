package com.example.Todomate.dto.fruit.request;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class FruitRequest {

    private String name;

    private LocalDate warehousingDate;

    private Long price;

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }
}
