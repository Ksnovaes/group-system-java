package com.ksnovaes.bora_jogar.domain.match;

import com.ksnovaes.bora_jogar.domain.address.Address;
import com.ksnovaes.bora_jogar.domain.address.AddressDTO;
import com.ksnovaes.bora_jogar.domain.participant.Participant;
import com.ksnovaes.bora_jogar.domain.user.GameIntensity;
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
import java.util.stream.Collectors;

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

    private GameIntensity intensidadePartida;

    private Date dataPartida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", nullable = true)
    private Address endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "criador_id", nullable = false)
    private User criador;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participantes = new ArrayList<>();

    public MatchResponseDTO toDTO() {
        return MatchResponseDTO.builder()
                .id(this.id)
                .tituloPartida(this.tituloPartida)
                .descricaoPartida(this.descricaoPartida)
                .intensidadePartida(this.intensidadePartida)
                .dataPartida(this.dataPartida)
                .endereco(this.endereco == null ? null : Address.fromEntity(this.endereco))
                .build();
    }

    public static Match fromCreationDTO(MatchCreationDTO dto, User criador, Address endereco) {
        return Match.builder()
                .tituloPartida(dto.tituloPartida())
                .descricaoPartida(dto.descricaoPartida())
                .dataPartida(dto.dataPartida())
                .criador(criador)
                .endereco(endereco)
                .build();
    }
}

