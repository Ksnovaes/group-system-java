package com.ksnovaes.bora_jogar.domain.participant;

import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "participante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match partida;

    @Enumerated(EnumType.STRING)
    private StatusParticipacao status;
}
