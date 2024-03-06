package com.example.Todomate.controller.Book;

import com.example.Todomate.dto.Book.request.BookLoanRequest;
import com.example.Todomate.dto.Book.request.BookSaveRequest;
import com.example.Todomate.service.Book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookSaveRequest request){
        bookService.saveBook(request.getName());
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request){
        bookService.loanBook(request.getUserName(), request.getBookName());
    }
}
