package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.participant.Participant;
import com.ksnovaes.bora_jogar.domain.participant.ParticipantAddDTO;
import com.ksnovaes.bora_jogar.domain.participant.StatusParticipacao;
import com.ksnovaes.bora_jogar.domain.user.User;
import com.ksnovaes.bora_jogar.exceptions.ResourceNotFoundException;
import com.ksnovaes.bora_jogar.repositories.MatchRepository;
import com.ksnovaes.bora_jogar.repositories.ParticipantRepository;
import com.ksnovaes.bora_jogar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParticipantService {
    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MatchRepository matchRepository;

    public void joinMatch(UUID matchId, UUID userId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        boolean alreadyParticipant = match.getParticipantes().stream()
                .anyMatch(participant -> participant.getUsuario().equals(userId));

        if (alreadyParticipant) {
            throw new IllegalStateException("User is already a participant of the match.");
        }

        Participant participant = new Participant();
        participant.setUsuario(user);
        participant.setPartida(match);
        participant.setStatus(StatusParticipacao.CONFIRMADO);

        participantRepository.save(participant);

        match.getParticipantes().add(participant);
        matchRepository.save(match);
    }

    public void leaveMatch(UUID matchId, UUID userId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));

        Participant participant = match.getParticipantes().stream()
                .filter(p -> p.getUsuario().getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Participant not found in this match"));

        match.getParticipantes().remove(participant);
        participantRepository.delete(participant);
        matchRepository.save(match);
    }
}
