package com.example.Todomate.controller.User;

import com.example.Todomate.dto.User.request.UserCreateRequest;
import com.example.Todomate.dto.User.request.UserUpdateRequest;
import com.example.Todomate.dto.User.response.UserResponse;
import com.example.Todomate.service.User.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(JdbcTemplate jdbcTemplate){
        this.userService = new UserService(jdbcTemplate);
    }

    @PostMapping("/user")   //POST /user
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request.getName(), request.getAge());
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
       return userService.getUser();
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
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }
}
