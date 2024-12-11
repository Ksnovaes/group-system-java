package com.ksnovaes.bora_jogar.domain.user;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;

public record UserLoginDTO(
        @NotNull String email,
        @NotNull String password
) {
}
