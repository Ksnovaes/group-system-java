package com.ksnovaes.bora_jogar.domain.participant;

import java.util.UUID;

public record ParticipantAddDTO(
        UUID matchId,
        UUID userId
) {
}
