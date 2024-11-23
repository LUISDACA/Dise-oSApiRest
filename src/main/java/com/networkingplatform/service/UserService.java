package com.networkingplatform.service;

import com.networkingplatform.model.User;
import com.networkingplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(User user) {
        if (userRepository.existsById(user.getUsername())) {
            return "Username already exists!";
        }
        userRepository.save(user);
        return "User created successfully!";
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}


