package com.GabrielOkumura.agendamento_consultas.dto;

import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroMedico.Especialidade;
import com.GabrielOkumura.agendamento_consultas.model.Medico;

public record DadosListagemMedico(Long id, String nome, Especialidade especialidade, String email) {

    public DadosListagemMedico(Medico medico) {

        this(medico.getId(), medico.getNome(), medico.getEspecialidade(), medico.getEmail());
    }
}
