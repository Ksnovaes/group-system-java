package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.address.AddressDTO;
import com.ksnovaes.bora_jogar.domain.user.GameIntensity;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.UUID;

@Builder
public record MatchResponseDTO(
        UUID id,
        String tituloPartida,
        String descricaoPartida,
        GameIntensity intensidadePartida,
        Date dataPartida,
        AddressDTO endereco,
        UUID criador,
        List<String> participantes
) {
}

