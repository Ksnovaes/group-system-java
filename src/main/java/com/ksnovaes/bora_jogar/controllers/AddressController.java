package com.ksnovaes.bora_jogar.controllers;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.address.AddressDTO;
import com.ksnovaes.bora_jogar.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody AddressDTO dto) {
        var createdAddress = addressService.createAddress(dto);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
}
