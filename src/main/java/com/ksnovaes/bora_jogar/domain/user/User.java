package com.ksnovaes.bora_jogar.domain.user;

import com.ksnovaes.bora_jogar.domain.match.Match;
import com.ksnovaes.bora_jogar.domain.participant.Participant;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

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

    private String apelido;

    @Enumerated(EnumType.STRING)
    private Genero sexo;

    private String email;

    private String password;

    private String telefone;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participant> participacoes;

    @OneToMany(mappedBy = "criador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Match> partidasCriadas;

    public static User fromDTO(UserDTO dto) {
        return User.builder()
                .nome(dto.nome())
                .apelido(dto.apelido())
                .sexo(dto.sexo())
                .email(dto.email())
                .password(dto.password())
                .telefone(dto.telefone())
                .build();
    }

    public UserDTO toDTO() {
        return UserDTO.builder()
                .nome(this.nome)
                .apelido(this.apelido)
                .sexo(this.sexo)
                .email(this.email)
                .password(this.password)
                .telefone(this.telefone)
                .build();
    }
}
