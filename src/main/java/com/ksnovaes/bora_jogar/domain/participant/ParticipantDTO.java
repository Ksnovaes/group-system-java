package com.ksnovaes.bora_jogar.domain.participant;

import com.ksnovaes.bora_jogar.domain.match.MatchResponseDTO;
import lombok.Builder;

@Builder
public record ParticipantDTO (
        String apelidoUsuario,
        StatusParticipacao status,
        MatchResponseDTO partida
) {
}

