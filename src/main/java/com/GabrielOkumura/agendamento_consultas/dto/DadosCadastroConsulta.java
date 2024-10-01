package com.GabrielOkumura.agendamento_consultas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroConsulta(

        @NotNull
        Long AgendamentoID,
        @NotNull
        Long pacienteID,
        @NotNull
        Long medicoID,
        @NotBlank
        LocalDateTime dataHoraInicio,
        @NotBlank
        LocalDateTime dataHoraFim,
        @NotBlank
        String descricao,
        @NotNull
        String status) {

}
