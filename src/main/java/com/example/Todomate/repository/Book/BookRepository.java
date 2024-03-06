package com.example.Todomate.repository.Book;

import com.example.Todomate.domain.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
