package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.match.MatchCreationDTO;
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

    public Match createMatch(MatchCreationDTO dto, UUID userId) {
        User criador = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        //Address endereco = addressRepository.findById(dto.enderecoId())
          //      .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        Address enderecoFic = new Address();
        enderecoFic.setId(UUID.randomUUID());
        enderecoFic.setCidade("Cidade fic");
        enderecoFic.setCep("72161829");
        enderecoFic.setEnderecoPartida("Fic");

        Match partida = new Match();
        partida.setTituloPartida(dto.tituloPartida());
        partida.setDescricaoPartida(dto.descricaoPartida());
        partida.setDataPartida(dto.dataPartida());
        partida.setEndereco(enderecoFic);
        partida.setCriador(criador);

        return matchRepository.save(partida);


    }

    public List<MatchResponseDTO> getAllMatches(UUID userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return matchRepository.findAll()
                .stream()
                .map(Match::toDTO)
                .collect(Collectors.toList());
    }


}
