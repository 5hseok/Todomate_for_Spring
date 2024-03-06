package com.example.Todomate.service.Book;

import com.example.Todomate.domain.Book.Book;
import com.example.Todomate.repository.Book.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookLoanRepository bookLoanRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(String name){
        bookRepository.save(new Book(name));
    }

    @Transactional
    public void loanBook(String userName, String bookName){

    }
}
