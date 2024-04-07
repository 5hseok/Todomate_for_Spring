package com.example.Todomate.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private long userid;
    private String bookName;
    private boolean loan;

    public UserLoanHistory(long userid, String bookName) {
        this.userid = userid;
        this.bookName = bookName;
        this.loan = false;
    }

    protected UserLoanHistory() {
    }
}
