package com.example.Todomate.repository.User;

import com.example.Todomate.domain.User.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserLoanRepository extends JpaRepository<UserLoanHistory, Long> {
    boolean existsByBookNameAndLoan(String bookName, boolean loan);
}
