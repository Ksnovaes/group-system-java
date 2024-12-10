package com.ksnovaes.bora_jogar.domain.match;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record MatchCreationDTO(
        @NotNull String tituloPartida,
        @NotNull String descricaoPartida,
        @NotNull MatchIntensity intensidade,
        @NotNull Date dataPartida,
        @NotNull UUID endereco_id,
        @NotNull UUID criador_id
        ) {
}
