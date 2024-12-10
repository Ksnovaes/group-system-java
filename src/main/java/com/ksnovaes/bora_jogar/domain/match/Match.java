package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.participant.Participant;
import com.ksnovaes.bora_jogar.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "partida")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {
    @Id
    @GeneratedValue
    private UUID id;

    private String tituloPartida;

    private String descricaoPartida;

    @Enumerated(EnumType.STRING)
    private MatchIntensity intensidadePartida;

    private Date dataPartida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Address endereco;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "criador_id", nullable = false)
    private User criador;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participantes = new ArrayList<>();
}

