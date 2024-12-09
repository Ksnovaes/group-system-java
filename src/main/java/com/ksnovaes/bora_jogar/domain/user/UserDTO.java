package com.ksnovaes.bora_jogar.domain.user;

import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.match.MatchResponseDTO;
import com.ksnovaes.bora_jogar.domain.participant.Participant;
import com.ksnovaes.bora_jogar.domain.participant.ParticipantDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public record UserDTO(
        @NotNull(message = "Nome não pode ser nulo") String nome,
        @NotNull(message = "Sobrenome não pode ser nulo") String sobrenome,
        @NotNull(message = "Nickname não pode ser nulo") String nickname,
        @NotNull(message = "Apelido não pode ser nulo") String apelido,
        @NotNull(message = "Gênero não pode ser nulo") Genero sexo,
        @NotNull(message = "Intensidade não pode ser nulo") GameIntensity intensidade,
        Date birthday,
        @NotNull(message = "Email não pode ser nulo") String email,
        @NotNull(message = "Número não pode ser nulo") String telefone,
        @NotNull(message = "Senha não pode ser nula") String password,
        List<ParticipantDTO> participacoes,
        List<MatchResponseDTO> partidasCriadas
) {
}

