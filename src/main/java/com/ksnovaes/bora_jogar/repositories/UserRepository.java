package com.ksnovaes.bora_jogar.repositories;

import com.ksnovaes.bora_jogar.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
