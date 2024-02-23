package com.example.Todomate.repository.Book;

import org.springframework.stereotype.Repository;


@Repository
public class BookMemoryRepository implements BookRepository{
//    private final List<Book> books = new ArrayList<Book>();

    @Override
    public void saveBook() {
        System.out.println("memory");
    }
}
