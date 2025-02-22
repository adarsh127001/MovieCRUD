package com.example.moviedb.controller;

import com.example.moviedb.dto.UserRequestDto;
import com.example.moviedb.model.User;
import com.example.moviedb.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok("User registered successfully!");
    }
}
