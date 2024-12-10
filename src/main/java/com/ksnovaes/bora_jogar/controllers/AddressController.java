package com.ksnovaes.bora_jogar.controllers;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.address.AddressDTO;
import com.ksnovaes.bora_jogar.domain.address.AddressResponseDTO;
import com.ksnovaes.bora_jogar.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponseDTO createAddress(@Valid @RequestBody AddressDTO dto) {
        return addressService.createAddress(dto);
    }

    @GetMapping("/{addressId}")
    public AddressResponseDTO getAddressById(@PathVariable UUID addressId) {
        return addressService.getAddressById(addressId);
    }
}
