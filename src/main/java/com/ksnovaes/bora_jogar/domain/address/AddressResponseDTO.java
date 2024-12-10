package com.ksnovaes.bora_jogar.domain.address;

import java.util.UUID;

public record AddressResponseDTO(
        UUID id,
        String cep,
        String enderecoPartida
) {
}
