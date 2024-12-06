package com.ksnovaes.bora_jogar.controllers;

import com.ksnovaes.bora_jogar.domain.user.LoginDTO;
import com.ksnovaes.bora_jogar.domain.user.User;
import com.ksnovaes.bora_jogar.domain.user.UserDTO;
import com.ksnovaes.bora_jogar.services.UserService;
import com.ksnovaes.bora_jogar.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginDTO loginDTO) {
        String message = userService.loginUser(loginDTO);
        return new ResponseEntity<>(new ApiResponse<>(message, null), HttpStatus.OK);
    }
}
