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
//    private final List<user> users = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    private final UserService userService = new UserService();
    public UserController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user")   //POST /user
    public void saveUser(@RequestBody UserCreateRequest request){
        String sql = "INSERT INTO user (name, age) VALUES(?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
//        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {    위의 코드는 이걸 lambda로 바꾼 것
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        });
    }
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(jdbcTemplate, request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        String readSql = "DELETE * FROM user WHERE name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum)-> 0, name).isEmpty();
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}
