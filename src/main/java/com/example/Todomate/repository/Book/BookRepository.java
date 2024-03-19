package com.example.Todomate.repository.Book;

import com.example.Todomate.domain.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
}
