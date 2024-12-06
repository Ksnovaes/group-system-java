package com.ksnovaes.bora_jogar.controllers;

import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.match.MatchCreationDTO;
import com.ksnovaes.bora_jogar.domain.match.MatchResponseDTO;
import com.ksnovaes.bora_jogar.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    MatchService matchService;

    @PostMapping("/create")
    public ResponseEntity<Match> createMatch(@RequestBody MatchCreationDTO dto,
                                             @RequestHeader("user-id") UUID userId) {
        var created = matchService.createMatch(dto, userId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/matches")
    public ResponseEntity<List<MatchResponseDTO>> getMatches(@RequestHeader("user-id") UUID userId) {
        List<MatchResponseDTO> matches = matchService.getAllMatches(userId);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }
}
