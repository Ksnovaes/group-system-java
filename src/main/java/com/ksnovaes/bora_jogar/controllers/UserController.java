package com.ksnovaes.bora_jogar.controllers;

import com.ksnovaes.bora_jogar.domain.user.User;
import com.ksnovaes.bora_jogar.domain.user.UserLoginDTO;
import com.ksnovaes.bora_jogar.domain.user.UserResponseDTO;
import com.ksnovaes.bora_jogar.domain.user.UserSignUpDTO;
import com.ksnovaes.bora_jogar.services.UserService;
import com.ksnovaes.bora_jogar.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO registerUser(@Valid @RequestBody UserSignUpDTO dto) {
        return userService.createUser(dto);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody UserLoginDTO dto) {
        return userService.login(dto);
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUserById(@PathVariable UUID userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
