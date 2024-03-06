package com.example.Todomate.controller.User;

import com.example.Todomate.dto.User.request.UserCreateRequest;
import com.example.Todomate.dto.User.request.UserUpdateRequest;
import com.example.Todomate.dto.User.response.UserResponse;
import com.example.Todomate.service.User.UserServiceV1;
import com.example.Todomate.service.User.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserServiceV2 userServiceV2;

    public UserController(UserServiceV2 userServiceV2){
        this.userServiceV2 = userServiceV2;
    }

    @PostMapping("/user")   //POST /user
    public void saveUser(@RequestBody UserCreateRequest request){
        userServiceV2.saveUser(request.getName(), request.getAge());
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
       return userServiceV2.getUser();
    }
//        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {    위의 코드는 이걸 lambda로 바꾼 것
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        });
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userServiceV2.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userServiceV2.deleteUser(name);
    }
}
