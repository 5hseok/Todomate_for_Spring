package com.example.Todomate.controller.User;

import com.example.Todomate.domain.User.user;
import com.example.Todomate.dto.User.request.UserCreateRequest;
import com.example.Todomate.dto.User.response.UserResponse;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final List<user> users = new ArrayList<>();
    @PostMapping("/user")   //POST /user
    public void saveUser(@RequestBody UserCreateRequest request){
        users.add(new user(request.getName(), request.getAge()));
    }
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        List<UserResponse> responses = new ArrayList<>();
        for (int i=0; i<users.size();i++){
            responses.add(new UserResponse(i+1, users.get(i)));
        }
        return responses;
    }
}
