package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.user.GameIntensity;
import com.ksnovaes.bora_jogar.domain.user.User;

import java.util.Date;
import java.util.UUID;

public record MatchResponseDTO(
        UUID id,
        String tituloPartida,
        String descricaoPartida,
        GameIntensity intensidadePartida,
        Date dataPartida,
        Address endereco,
        User criador
) {
}
