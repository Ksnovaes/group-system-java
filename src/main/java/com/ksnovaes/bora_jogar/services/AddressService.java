package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.address.AddressDTO;
import com.ksnovaes.bora_jogar.exceptions.ResourceNotFoundException;
import com.ksnovaes.bora_jogar.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address createAddress(AddressDTO dto) {
        Address newAddress = new Address();
        newAddress.setCep(dto.cep());
        newAddress.setEnderecoPartida(dto.enderecoPartida());

        return addressRepository.save(newAddress);
    }

    public Address getAddressById(UUID id) {
        var entity = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No addresses found."));
        return entity;
    }

    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(Address::toDTO)
                .collect(Collectors.toList());
    }
}
