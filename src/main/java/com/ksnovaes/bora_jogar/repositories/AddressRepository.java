package com.ksnovaes.bora_jogar.repositories;

import com.ksnovaes.bora_jogar.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
