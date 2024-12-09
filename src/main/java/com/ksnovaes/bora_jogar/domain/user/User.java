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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Participant> participacoes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Match> partidasCriadas = new ArrayList<>();

    public static User fromDTO(UserDTO dto) {
        return User.builder()
                .nome(dto.nome())
                .sobrenome(dto.sobrenome())
                .nickname(dto.nickname())
                .apelido(dto.apelido())
                .sexo(dto.sexo())
                .intensidade(dto.intensidade())
                .birthday(dto.birthday())
                .email(dto.email())
                .password(dto.password())
                .telefone(dto.telefone())
                .build();
    }

    public UserDTO toDTO() {
        return UserDTO.builder()
                .nome(this.nome)
                .sobrenome(this.sobrenome)
                .nickname(this.nickname)
                .apelido(this.apelido)
                .sexo(this.sexo)
                .intensidade(this.intensidade)
                .birthday(this.birthday)
                .email(this.email)
                .password(this.password)
                .telefone(this.telefone)
                .build();
    }
}
