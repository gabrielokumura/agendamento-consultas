package com.GabrielOkumura.agendamento_consultas.dto;

import java.time.LocalDateTime;

public record DadosAtualizaConsulta(Long id, Long pacienteID, Long medicoID, Long agendamentoID, LocalDateTime dataHoraInicio,LocalDateTime dataHoraFim, String descricao, String status) {
}
