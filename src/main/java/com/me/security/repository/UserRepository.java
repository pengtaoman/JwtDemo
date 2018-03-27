package com.me.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.me.model.security.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User save(User user);
}
