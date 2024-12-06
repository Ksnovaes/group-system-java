package com.ksnovaes.bora_jogar.domain.user;

import jakarta.validation.constraints.NotNull;

public record LoginDTO (
        @NotNull String nickname,
        @NotNull String email,
        @NotNull String password
) {
}
