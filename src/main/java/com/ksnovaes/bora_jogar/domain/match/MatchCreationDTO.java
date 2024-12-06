package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.user.GameIntensity;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record MatchCreationDTO (
        @NotNull(message = "Título não pode ser nulo") String tituloPartida, String descricaoPartida,
        @NotNull(message = "Data da partida não pode ser nula") Date dataPartida,
        @NotNull(message = "ID do endereço não pode ser nulo") UUID enderecoId,
        @NotNull(message = "Intensidade da partida não pode ser nula") GameIntensity intensidadePartida
        ) {
}
