package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.participant.Participant;
import com.ksnovaes.bora_jogar.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "partida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue
    private UUID id;

    private String tituloPartida;

    private String descricaoPartida;

    private Date dataPartida;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Address endereco;

    @ManyToOne
    @JoinColumn(name = "criador_id", nullable = false)
    private User criador;

    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participant> participantes;
}
