package com.example.demo;

import com.example.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<User, Long> {
    // Find a user by email and password
	User findByUsername(String username);
    User findByEmailAndPassword(String email, String password);
}
