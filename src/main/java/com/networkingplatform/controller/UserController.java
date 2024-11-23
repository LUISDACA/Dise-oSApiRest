package com.networkingplatform.controller;

import com.networkingplatform.model.User;
import com.networkingplatform.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

        public UserController(UserService userService) {
        this.userService = userService;
    }

    
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.createUser(user);
    }

    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        
        return userService.authenticate(username, password) ? "Login successful!" : "Invalid credentials!";
    }
}



