package com.GabrielOkumura.agendamento_consultas.dto;

import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroMedico.Especialidade;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaMedico(
        @NotBlank
        Long id, String nome, String email, Especialidade especialidade) {
}
