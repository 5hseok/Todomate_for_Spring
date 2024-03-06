package com.example.Todomate.dto.fruit.response;

public class FruitCountResponse {

    private long count;

    public FruitCountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
