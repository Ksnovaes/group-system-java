package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.user.*;
import com.ksnovaes.bora_jogar.exceptions.ResourceNotFoundException;
import com.ksnovaes.bora_jogar.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDTOMapper userDTOMapper;

    public UserResponseDTO createUser(UserSignUpDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setSobrenome(dto.sobrenome());
        user.setNickname(dto.nickname());
        user.setSexo(dto.sexo());
        user.setIntensidade(dto.intensidade());
        user.setTelefone(dto.telefone());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        userRepository.save(user);

        return userDTOMapper.apply(user);
    }


    public UserResponseDTO getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userDTOMapper.apply(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public UserLoginResponseDTO login(UserLoginDTO dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new ResourceNotFoundException("Email ou apelido não encontrado."));

        if (!user.getPassword().equals(dto.password())) {
            throw new ResourceNotFoundException("Senha incorreta.");
        }

        return new UserLoginResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );
    }



}
