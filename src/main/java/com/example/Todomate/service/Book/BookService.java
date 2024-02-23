package com.example.Todomate.service.Book;

import com.example.Todomate.repository.Book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(){
        bookRepository.saveBook();
    }
}
