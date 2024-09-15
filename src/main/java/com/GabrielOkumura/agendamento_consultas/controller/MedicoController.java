package com.GabrielOkumura.agendamento_consultas.controller;

import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroMedico.DadosCadastroMedico;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MedicoController {

    @PostMapping
    public void createMedico(@RequestBody DadosCadastroMedico DadosCadastroMedico) {
        System.out.println(DadosCadastroMedico);
    }
}
