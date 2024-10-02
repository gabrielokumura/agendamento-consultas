package com.GabrielOkumura.agendamento_consultas.dto;

import com.GabrielOkumura.agendamento_consultas.model.Medico;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaMedico(

        Long id, String nome, String email, Especialidade especialidade) {

    public DadosAtualizaMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getEspecialidade());
    }
}
