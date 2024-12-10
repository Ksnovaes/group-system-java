package com.ksnovaes.bora_jogar.controllers;

import com.ksnovaes.bora_jogar.domain.participant.Participant;
import com.ksnovaes.bora_jogar.domain.participant.ParticipantAddDTO;
import com.ksnovaes.bora_jogar.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/participant")
public class ParticipantController {
    @Autowired
    ParticipantService participantService;

    @PostMapping("/{matchId}/join")
    public ResponseEntity<String> joinMatch(@PathVariable UUID matchId,
                                            @RequestHeader("user-id") UUID userId) {
        participantService.joinMatch(matchId, userId);
        return ResponseEntity.ok("User joined the match successfully!");
    }

    @PostMapping("/{matchId}/leave")
    public ResponseEntity<String> leaveMatch(@PathVariable UUID matchId,
                                             @RequestHeader("user-id") UUID userId) {
        participantService.leaveMatch(matchId, userId);
        return ResponseEntity.ok("User left the match successfully!");
    }


}
