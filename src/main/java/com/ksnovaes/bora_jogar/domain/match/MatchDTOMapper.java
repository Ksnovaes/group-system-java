package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.participant.ParticipantDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MatchDTOMapper implements Function<Match, MatchResponseDTO> {
    @Override
    public MatchResponseDTO apply(Match match) {
        return new MatchResponseDTO(
                match.getId(),
                match.getTituloPartida(),
                match.getDescricaoPartida(),
                match.getIntensidadePartida(),
                match.getDataPartida(),
                match.getEndereco().getId(),
                match.getCriador().getId(),
                match.getParticipantes()
                        .stream()
                        .map(participant -> participant.getUsuario().getApelido())
                        .collect(Collectors.toList())
        );
    }
}
