package com.ksnovaes.bora_jogar.domain.user;

import java.util.UUID;

public record UserLoginResponseDTO(
        UUID id,
        String email,
        String password
) {
}
