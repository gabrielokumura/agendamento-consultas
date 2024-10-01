package com.GabrielOkumura.agendamento_consultas.dto;

import java.time.LocalDateTime;

public record DadosAtualizaAgendamento(Long id, LocalDateTime dataHoraAgendamento, Status status, Long pacienteID, Long medicoID) {
}
