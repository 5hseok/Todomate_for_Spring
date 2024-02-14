package com.example.Todomate.dto.User.response;

import com.example.Todomate.domain.User.user;

public class UserResponse {
    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, user user) {
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
