package com.ksnovaes.bora_jogar.repositories;

import com.ksnovaes.bora_jogar.domain.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
}
