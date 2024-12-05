package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.user.User;
import com.ksnovaes.bora_jogar.domain.user.UserDTO;
import com.ksnovaes.bora_jogar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(UserDTO dto) {
        return userRepository.save(dto.toEntity());
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().
                stream().
                map(User::toDTO)
                .collect(Collectors.toList());
    }
}
