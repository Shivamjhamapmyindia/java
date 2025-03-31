package com.learningrestapi.learningrestapi.service;

import com.learningrestapi.learningrestapi.model.UserModel;
import com.learningrestapi.learningrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to validate if the user exists and credentials match
    public boolean isValidUser(String username, String password) {
        // This is a simple check, but in production, you'd likely hash the password
        UserModel user = userRepository.findByEmail(username);
        return user != null && user.getPassword().equals(password); // Password check
    }

    // Method to register a user
    public ResponseEntity<String> registerUser(UserModel user) {
        // Check if the user already exists by email
        UserModel existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            // Return a response indicating the user already exists
            return new ResponseEntity<>("User with this email already exists.", HttpStatus.BAD_REQUEST); // 400 Bad
                                                                                                         // Request
        }

        // If user doesn't exist, save the new user
        userRepository.save(user);

        // Return a success response
        return new ResponseEntity<>("Registration successful", HttpStatus.CREATED); // 201 Created
    }
}
