package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Table(name = "partida")
@Entity
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
    @JoinColumn(name = "id-endereco")
    private Address idEndereco;
}
