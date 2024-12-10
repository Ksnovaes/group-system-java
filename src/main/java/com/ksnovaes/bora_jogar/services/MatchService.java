package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.match.MatchCreationDTO;
import com.ksnovaes.bora_jogar.domain.match.MatchDTOMapper;
import com.ksnovaes.bora_jogar.domain.match.MatchResponseDTO;
import com.ksnovaes.bora_jogar.domain.user.User;
import com.ksnovaes.bora_jogar.exceptions.ResourceNotFoundException;
import com.ksnovaes.bora_jogar.repositories.AddressRepository;
import com.ksnovaes.bora_jogar.repositories.MatchRepository;
import com.ksnovaes.bora_jogar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired
    MatchRepository matchRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MatchDTOMapper matchDTOMapper;

    public MatchResponseDTO createMatch(MatchCreationDTO dto, String userIdHeader) {
        if (userIdHeader == null | userIdHeader.isBlank()) {
            throw new IllegalArgumentException("Header 'user-id' is required");
        }

        UUID userId = UUID.fromString(userIdHeader);
        User creator = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
        Address address = addressRepository.findById(dto.endereco_id())
                .orElseThrow(() -> new ResourceNotFoundException("Address not found."));

        Match match = Match.builder()
                .tituloPartida(dto.tituloPartida())
                .descricaoPartida(dto.descricaoPartida())
                .intensidadePartida(dto.intensidade())
                .dataPartida(dto.dataPartida())
                .endereco(address)
                .criador(creator)
                .build();

        matchRepository.save(match);
        return new MatchResponseDTO(
                match.getId(),
                match.getTituloPartida(),
                match.getDescricaoPartida(),
                match.getIntensidadePartida(),
                match.getDataPartida(),
                match.getEndereco().getId(),
                creator.getId(),
                null
        );
    }

    public MatchResponseDTO getMatchById(UUID id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found."));
        return matchDTOMapper.apply(match);
    }

    public List<MatchResponseDTO> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(matchDTOMapper)
                .collect(Collectors.toList());
    }

    public MatchResponseDTO updateMatch(UUID id, MatchCreationDTO dto) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found."));

        match.setTituloPartida(dto.tituloPartida());
        match.setDescricaoPartida(dto.descricaoPartida());
        match.setIntensidadePartida(dto.intensidade());
        match.setDataPartida(dto.dataPartida());

        matchRepository.save(match);
        return matchDTOMapper.apply(match);
    }
}
