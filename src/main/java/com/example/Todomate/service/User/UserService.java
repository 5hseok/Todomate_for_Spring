package com.example.Todomate.service.User;

import com.example.Todomate.dto.User.request.UserUpdateRequest;
import com.example.Todomate.dto.User.response.UserResponse;
import com.example.Todomate.repository.User.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String name, int age){
        userRepository.saveUserToDB(name, age);
    }

    public List<UserResponse> getUser(){
        return userRepository.getUserFromDB();
    }

    public void updateUser(UserUpdateRequest request){
        if(userRepository.checkUserExist(request.getId())){
            throw new IllegalArgumentException();
        }
        userRepository.updateUserToDB(request);
    }

    public void deleteUser(String name){
        String readSql = "DELETE * FROM user WHERE name = ?";

        if(userRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userRepository.deleteUserToDB(name);
    }
}
