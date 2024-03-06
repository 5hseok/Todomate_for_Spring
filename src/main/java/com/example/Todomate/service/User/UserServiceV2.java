package com.example.Todomate.service.User;

import com.example.Todomate.domain.User.User;
import com.example.Todomate.domain.User.UserRepository;
import com.example.Todomate.dto.User.request.UserCreateRequest;
import com.example.Todomate.dto.User.request.UserUpdateRequest;
import com.example.Todomate.dto.User.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String name, int age){
        //save 메소드에 객체를 넣어주면 INSERT SQL이 자동으로 날아간다.
        userRepository.save(new User(name, age));
    }
    public List<UserResponse> getUser(){
        //findall 메소드를 쓰면 모든 데이터를 가져온다
        return  userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request){
        //select * from user where id = ?
        //결과 : Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.updateName(request.getName());
        userRepository.save(user);

    }
    public void deleteUser(String name){

        User user = userRepository.findByName(name);
        if (user == null){
            throw new IllegalArgumentException();
        }
        userRepository.delete(user);
    }

}
