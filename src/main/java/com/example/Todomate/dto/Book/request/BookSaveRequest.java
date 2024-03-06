package com.example.Todomate.dto.Book.request;

public class BookSaveRequest {
    private String name;

    public BookSaveRequest() {
    }

    public BookSaveRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
