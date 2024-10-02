package com.GabrielOkumura.agendamento_consultas.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DadosCadastroAgendamento (
        @NotNull
        LocalDateTime dataHoraAgendamento,
        @NotNull
        Status status,
        @NotNull
        Long pacienteID,
        @NotNull
        Long medicoID){
}
