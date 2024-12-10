package com.ksnovaes.bora_jogar.services;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.address.AddressDTO;
import com.ksnovaes.bora_jogar.domain.address.AddressResponseDTO;
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

    public AddressResponseDTO createAddress(AddressDTO dto) {
        Address address = Address.builder()
                .cep(dto.cep())
                .enderecoPartida(dto.enderecoPartida())
                .build();
        addressRepository.save(address);
        return new AddressResponseDTO(
                address.getId(),
                address.getCep(),
                address.getEnderecoPartida()
        );
    }

    public AddressResponseDTO getAddressById(UUID id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found."));
        return new AddressResponseDTO(
                address.getId(),
                address.getCep(),
                address.getEnderecoPartida()
        );
    }

    public List<AddressResponseDTO> getAllAdresses() {
        return addressRepository.findAll().stream()
                .map(address -> new AddressResponseDTO(
                        address.getId(),
                        address.getCep(),
                        address.getEnderecoPartida()
                ))
                .collect(Collectors.toList());
    }

    public AddressResponseDTO updateAddress(UUID id, AddressDTO dto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado"));

        address.setCep(dto.cep());
        address.setEnderecoPartida(dto.enderecoPartida());

        addressRepository.save(address);
        return new AddressResponseDTO(
                address.getId(),
                address.getCep(),
                address.getEnderecoPartida()
        );
    }

    public void deleteAddress(UUID id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException("Endereço não encontrado");
        }
        addressRepository.deleteById(id);
    }
}
