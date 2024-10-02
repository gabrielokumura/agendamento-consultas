package com.GabrielOkumura.agendamento_consultas.dto;

import com.GabrielOkumura.agendamento_consultas.model.Paciente;

public record DadosListagemPaciente(Long id,String nome, String email, String telefone) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNomme(), paciente.getEmail(), paciente.getTelefone());
    }
}
