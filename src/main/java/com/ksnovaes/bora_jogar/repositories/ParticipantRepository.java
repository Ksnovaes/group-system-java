package com.ksnovaes.bora_jogar.repositories;

import com.ksnovaes.bora_jogar.domain.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
