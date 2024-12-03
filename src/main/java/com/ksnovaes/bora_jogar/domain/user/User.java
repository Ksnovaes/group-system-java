package com.ksnovaes.bora_jogar.domain.user;

import com.ksnovaes.bora_jogar.domain.match.Match;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    private String apelido;

    private Genero sexo;

    private String email;

    private String password;

    private String telefone;

    @OneToMany
    @JoinColumn(name = "partidas")
    private List<Match> partidas;
}
