package com.ksnovaes.bora_jogar.domain.address;

import jakarta.validation.constraints.NotNull;

public record AddressDTO(
        @NotNull String cep,
        @NotNull String enderecoPartida
) {
}
