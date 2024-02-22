package com.example.Todomate.dto.fruit.response;

public class FruitResponse {
    private final long salesAmount;
    private final long notSalesAmount;

    public FruitResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
