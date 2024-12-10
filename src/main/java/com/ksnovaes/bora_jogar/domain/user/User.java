package com.ksnovaes.bora_jogar.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.participant.Participant;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    private String sobrenome;

    private String nickname;

    private String apelido;

    @Enumerated(EnumType.STRING)
    private Genero sexo;

    @Enumerated(EnumType.STRING)
    private GameIntensity intensidade;

    @DateTimeFormat
    private Date birthday;

    private String email;

    private String password;

    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participant> participacoes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Match> partidasCriadas = new ArrayList<>();
}
