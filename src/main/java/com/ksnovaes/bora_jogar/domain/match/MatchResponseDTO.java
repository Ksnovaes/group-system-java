package com.ksnovaes.bora_jogar.domain.match;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record MatchResponseDTO(
        UUID partidaId,
        String tituloPartida,
        String descricaoPartida,
        MatchIntensity intensidade,
        Date dataPartida,
        UUID enderecoId,
        UUID criadorId,
        List<String> nicknames
) {
}
