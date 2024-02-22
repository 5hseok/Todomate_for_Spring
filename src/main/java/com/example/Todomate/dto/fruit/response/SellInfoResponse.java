package com.example.Todomate.dto.fruit.response;

public class SellInfoResponse {
    private final boolean sell;
    private final long totalPrice;

    public SellInfoResponse(boolean sell, long totalPrice) {
        this.sell = sell;
        this.totalPrice = totalPrice;
    }

    public boolean isSell() {
        return sell;
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}
