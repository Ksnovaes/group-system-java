package com.ksnovaes.bora_jogar.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record UserSignUpDTO(
        @NotNull String nome,
        @NotNull String sobrenome,
        @NotNull String nickname,
        @NotNull String apelido,
        @NotNull Genero sexo,
        @NotNull GameIntensity intensidade,
        @NotNull String telefone,
        @NotNull Date dataNascimento,
        @NotNull @Email String email,
        @NotNull String password
        ) {
}
