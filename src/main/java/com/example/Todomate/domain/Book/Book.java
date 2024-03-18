package com.example.Todomate.domain.Book;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String name;

    protected Book() {
    }

    public Book(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("잘못된 책 이름이 입력되었습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
