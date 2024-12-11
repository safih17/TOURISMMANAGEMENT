package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private Userrepo userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Update password method
    public boolean updatePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setPassword(newPassword);  // Set the new password
            userRepository.save(user);  // Save the updated user entity
            return true;
        }
        return false;  // User not found
    }
    public String getEmailByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getEmail(); // Return the email of the user
        }
        throw new RuntimeException("User not found");
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
