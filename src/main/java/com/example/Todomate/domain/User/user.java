package com.example.Todomate.domain.User;

public class user {
    private final String name;
    private final Integer age;

    public user(String name, Integer age) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("잘못된 name(%s)이 들어왔습니다.");
        }        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
