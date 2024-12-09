package com.ksnovaes.bora_jogar.domain.address;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record AddressDTO (
        @NotNull UUID id,
        @NotNull String cep,
        @NotNull String enderecoPartida
) {
}
