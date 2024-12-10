package com.ksnovaes.bora_jogar.repositories;

import com.ksnovaes.bora_jogar.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailOrNickname(String nickname, String email);
}
