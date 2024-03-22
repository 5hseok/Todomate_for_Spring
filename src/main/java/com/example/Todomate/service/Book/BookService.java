package com.example.Todomate.service.Book;

import com.example.Todomate.domain.Book.Book;
import com.example.Todomate.domain.User.User;
import com.example.Todomate.domain.User.UserLoanHistory;
import com.example.Todomate.domain.User.UserRepository;
import com.example.Todomate.repository.Book.BookRepository;
import com.example.Todomate.repository.User.UserLoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanRepository userLoanRepository;
    private final UserRepository userRepository;
    public BookService(BookRepository bookRepository, UserLoanRepository userLoanRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanRepository = userLoanRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public void saveBook(String name){
        bookRepository.save(new Book(name));
    }

    @Transactional
    public void loanBook(String userName, String bookName){
       Book book = bookRepository.findByName(bookName)
                .orElseThrow(IllegalArgumentException::new);
        //isReturn은 반납되었는가를 묻는 것. isReturn이 false면 반납을 아직 안한 것이고, isReturn이 true면 반납한 것이다.
       if(userLoanRepository.existsByNameAndIsReturn(book.getName(), false)){
           throw new IllegalArgumentException("이미 대출 중인 도서입니다.");
       }

        User user = userRepository.findByName(userName)
                .orElseThrow(IllegalArgumentException::new);

       userLoanRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }
    @Transactional
    public void returnBook(String userName, String bookName){
        Book book = bookRepository.findByName(bookName)
                .orElseThrow(IllegalArgumentException::new);

        //isReturn은 반납되었는가를 묻는 것. isReturn이 false면 반납을 아직 안한 것이고, isReturn이 true면 반납한 것이다.
        if(userLoanRepository.existsByNameAndIsReturn(book.getName(), true)){
            throw new IllegalArgumentException("이미 반납이 완료된 도서입니다.");
        }

        User user = userRepository.findByName(userName)
                .orElseThrow(IllegalArgumentException::new);

        userLoanRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }
} 
