package com.GabrielOkumura.agendamento_consultas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotNull
        Especialidade especialidade,
        @NotBlank
        @Email
        String email) {
}
