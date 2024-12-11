package com.ksnovaes.bora_jogar.domain.user;

import com.ksnovaes.bora_jogar.domain.match.MatchResponseDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserDTOMapper implements Function<User, UserResponseDTO> {
    @Override
    public UserResponseDTO apply(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getNome(),
                user.getSobrenome(),
                user.getNickname(),
                user.getSexo(),
                user.getIntensidade(),
                user.getBirthday(),
                user.getTelefone(),
                user.getEmail(),
                user.getPassword(),
                user.getPartidasCriadas().stream()
                        .map(match -> new MatchResponseDTO(
                                match.getId(),
                                match.getTituloPartida(),
                                match.getDescricaoPartida(),
                                match.getIntensidadePartida(),
                                match.getDataPartida(),
                                match.getEndereco().getId(),
                                match.getCriador().getId(),
                                match.getParticipantes().stream()
                                        .map(participant -> participant.getUsuario().getNickname())
                                        .collect(Collectors.toList())
                        ))
                        .collect(Collectors.toList())
        );
    }
}
