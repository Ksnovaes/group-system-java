package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.user.LoginDTO;
import com.ksnovaes.bora_jogar.domain.user.User;
import com.ksnovaes.bora_jogar.domain.user.UserDTO;
import com.ksnovaes.bora_jogar.exceptions.ResourceNotFoundException;
import com.ksnovaes.bora_jogar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().
                stream().
                map(User::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(UUID id) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found with id: " + id));
        return entity.toDTO();
    }

    public User createUser(UserDTO dto) {
        return userRepository.save(dto.toEntity());
    }

    public User updateUser(UUID id, UserDTO dto) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found with id: " + id));
        return userRepository.save(entity);
    }

    public void deleteUser(UUID id) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found with id: " + id));
        userRepository.delete(entity);
    }

    public String loginUser(LoginDTO dto) {
        var optionalUser = userRepository.findByEmailOrNickname(dto.email(), dto.nickname());

        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("No records found with this email or nickname.");
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(dto.password())) {
            throw new ResourceNotFoundException("Wrong password.");
        }

        return "Logged in successfully!";
    }
}
