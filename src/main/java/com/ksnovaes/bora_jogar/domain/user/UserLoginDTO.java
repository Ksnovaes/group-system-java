package com.ksnovaes.bora_jogar.domain.user;

import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public record UserLoginDTO(
        @NotNull String nicknameOrEmail,
        @NotNull String password
) {
}
