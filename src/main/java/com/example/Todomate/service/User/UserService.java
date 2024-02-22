package com.example.Todomate.service.User;

import com.example.Todomate.dto.User.request.UserUpdateRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;

public class UserService {
    public void updateUser(JdbcTemplate jdbcTemplate, UserUpdateRequest request){
        String readSql = "SELECT * FROM user WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum)-> 0, request.getId()).isEmpty();
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());

    }
}
