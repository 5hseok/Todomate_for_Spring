package com.example.Todomate.repository.User;

import com.example.Todomate.domain.User.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

}
