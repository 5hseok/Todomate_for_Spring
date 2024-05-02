package com.example.Todomate.service.User;

import com.example.Todomate.domain.User.SiteUser;
import com.example.Todomate.repository.User.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SiteUserService {

        private final SiteUserRepository SiteUserRepository;
        private final PasswordEncoder passwordEncoder;

        public SiteUser create(String username, String email, String password) {
            SiteUser user = new SiteUser();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            this.SiteUserRepository.save(user);
            return user;
       }
}

