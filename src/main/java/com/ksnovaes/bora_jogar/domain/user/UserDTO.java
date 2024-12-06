package com.ksnovaes.bora_jogar.domain.user;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Date;


@Builder
public record UserDTO(
        @NotNull(message = "Nome não pode ser nulo") String nome,
        @NotNull(message = "Sobrenome não pode ser nulo") String sobrenome,
        @NotNull(message = "Nickname não pode ser nulo") String nickname,
        @NotNull(message = "Apelido não pode ser nulo") String apelido,
        @NotNull(message = "Gênero não pode ser nulo") Genero sexo,
        @NotNull(message = "Intensidade não pode ser nulo") GameIntensity intensidade,
        @NotNull(message = "Data de nascimento não pode ser nulo") Date birthday,
        @NotNull(message = "Email não pode ser nulo") String email,
        @NotNull(message = "Número não pode ser nulo") String telefone,
        @NotNull(message = "Senha não pode ser nula") String password
) {
    public User toEntity() {
        return User.builder()
                .nome(this.nome)
                .sobrenome(this.sobrenome)
                .nickname(this.nickname)
                .apelido(this.apelido)
                .sexo(this.sexo)
                .intensidade(this.intensidade)
                .birthday(this.birthday)
                .email(this.email)
                .telefone(this.telefone)
                .password(this.password)
                .build();
    }
}
