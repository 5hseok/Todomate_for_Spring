package com.example.Todomate.repository.User;

import com.example.Todomate.domain.User.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanRepository extends JpaRepository<UserLoanHistory, Long> {
    boolean existsByBookNameAndLoan(String bookName, boolean loan);
    UserLoanHistory findByUseridAndBookName(long userId, String bookName);
}
