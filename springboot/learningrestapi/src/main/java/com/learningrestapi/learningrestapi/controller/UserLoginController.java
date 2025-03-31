package com.learningrestapi.learningrestapi.controller;

import com.learningrestapi.learningrestapi.model.UserModel;
import com.learningrestapi.learningrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // Use RestController for automatic JSON response conversion
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserService userService;

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam("email") String username,
            @RequestParam("password") String password) {
        // Create a map to hold the response data
        Map<String, String> response = new HashMap<>();

        // Here you would normally check the username and password against the database
        // For example, let's assume userService has a method to validate the user
        if (userService.isValidUser(username, password)) {
            response.put("email", username);
            response.put("message", "Login successful");
            return new ResponseEntity<>(response, HttpStatus.OK); // 200 OK status
        } else {
            response.put("error", "Invalid credentials");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // 400 Bad Request status
        }
    }

    // Register Endpoint
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        // Create the UserModel object
        UserModel newUser = new UserModel(email, password);

        // Call the service method to register the user
        return userService.registerUser(newUser);
    }
}
