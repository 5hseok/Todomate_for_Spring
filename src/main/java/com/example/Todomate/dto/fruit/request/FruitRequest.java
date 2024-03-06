package com.example.Todomate.dto.fruit.request;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class FruitRequest {

    private String name;

    private LocalDate warehousingDate;

    private long price;

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
