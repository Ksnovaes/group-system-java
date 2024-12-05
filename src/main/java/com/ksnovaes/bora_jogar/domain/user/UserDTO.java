package com.ksnovaes.bora_jogar.domain.user;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record UserDTO(
        @NotNull(message = "Nome não pode ser nulo") String nome,
        @NotNull(message = "Apelido não pode ser nulo") String apelido,
        @NotNull(message = "Gênero não pode ser nulo") Genero sexo,
        @NotNull(message = "Email não pode ser nulo") String email,
        @NotNull(message = "Número não pode ser nulo") String telefone,
        @NotNull(message = "Senha não pode ser nula") String password
) {
    public User toEntity() {
        return User.builder()
                .nome(this.nome)
                .apelido(this.apelido)
                .sexo(this.sexo)
                .email(this.email)
                .telefone(this.telefone)
                .password(this.password)
                .build();
    }
}
