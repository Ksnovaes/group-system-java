package com.ksnovaes.bora_jogar.domain.user;

import com.ksnovaes.bora_jogar.domain.match.MatchResponseDTO;
import jakarta.validation.constraints.Null;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String nome,
        String sobrenome,
        String nickname,
        Genero sexo,
        GameIntensity intensidade,
        Date dataNascimento,
        String telefone,
        String email,
        String password,
        List<MatchResponseDTO> partidas
) {
}
