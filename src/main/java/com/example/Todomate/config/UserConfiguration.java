package com.example.Todomate.config;

import com.example.Todomate.repository.User.UserRepository;
import com.example.Todomate.service.User.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UserConfiguration {
//    @Bean
//    public UserRepository userRepository(JdbcTemplate jdbcTemplate){
//        return new UserRepository(jdbcTemplate);
//    }
//    @Bean
//    public UserService userService(UserRepository userRepository){
//        return new UserService(userRepository);
//    }
}
