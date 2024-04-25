package com.example.Todomate.service.User;

import com.example.Todomate.domain.User.SiteUser;
import com.example.Todomate.domain.User.User;
import com.example.Todomate.domain.User.UserRepository;
import com.example.Todomate.repository.User.SiteUserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SiteUseService {

        private final SiteUserRepository SiteUserRepository;
        private final PasswordEncoder passwordEncoder;

        public SecurityProperties.User create(String username, String email, String password) {
            SiteUser user = new SiteUser();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            this.SiteUserRepository.save(user);
            return user;
       }
}

