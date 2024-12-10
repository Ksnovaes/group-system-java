package com.ksnovaes.bora_jogar.controllers;

import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.match.MatchCreationDTO;
import com.ksnovaes.bora_jogar.domain.match.MatchResponseDTO;
import com.ksnovaes.bora_jogar.services.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/match")
public class MatchController {
    @Autowired
    MatchService matchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchResponseDTO createMatch(@Valid @RequestBody MatchCreationDTO dto,
                                        @RequestHeader("user-id") String userId) {
        return matchService.createMatch(dto, userId);
    }

    @GetMapping("/{matchId}")
    public MatchResponseDTO getMatch(@PathVariable UUID matchId) {
        return matchService.getMatchById(matchId);
    }

    @GetMapping
    public List<MatchResponseDTO> getAllMatches() {
        return matchService.getAllMatches();
    }
}
