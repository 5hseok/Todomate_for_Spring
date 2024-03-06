package com.example.Todomate.domain.Fruit;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "warehouse")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 20)
    private String name;

    private LocalDate warehousingDate;
    @Column(nullable = false)
    private long price;
    private boolean sell;

    protected Fruit() {
    }

    public Fruit(long id, String name, LocalDate warehousingDate, long price) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.sell = false;
    }

    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.sell= false;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public boolean isSell() {
        return sell;
    }

    public void setSell(boolean sell) {
        this.sell = sell;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
