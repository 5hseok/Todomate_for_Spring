package com.example.Todomate.service.User;

import com.example.Todomate.dto.User.request.UserUpdateRequest;
import com.example.Todomate.dto.User.response.UserResponse;
import com.example.Todomate.repository.User.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {
    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(String name, int age){
        userJdbcRepository.saveUserToDB(name, age);
    }

    public List<UserResponse> getUser(){
        return userJdbcRepository.getUserFromDB();
    }

    public void updateUser(UserUpdateRequest request){
        if(userJdbcRepository.checkUserExist(request.getId())){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserToDB(request);
    }

    public void deleteUser(String name){
        String readSql = "DELETE * FROM user WHERE name = ?";

        if(userJdbcRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.deleteUserToDB(name);
    }
}
