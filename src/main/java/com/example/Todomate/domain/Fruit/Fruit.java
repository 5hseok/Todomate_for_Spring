package com.example.Todomate.domain.Fruit;

import java.time.LocalDate;

public class Fruit {
    private long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
    private boolean sell;

    public Fruit(String name, LocalDate warehousingDate, long price) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("잘못된 name(%s)이 들어왔습니다.");
        }
        if (price < 0){
            throw new IllegalArgumentException("잘못된 price(%s)가 들어왔습니다.");
        }
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.sell = false;
    }

    public Fruit(long id, String name, long price, boolean sell) {
        this.id  = id;
        this.name = name;
        this.price = price;
        this.sell = sell;
    }

    public Fruit(long price, boolean sell){

        this.price = price;
        this.sell = sell;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public boolean isSell() {
        return sell;
    }
}
