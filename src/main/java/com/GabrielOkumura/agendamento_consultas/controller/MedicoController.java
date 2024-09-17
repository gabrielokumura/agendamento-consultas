package com.GabrielOkumura.agendamento_consultas.controller;

import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroMedico.DadosCadastroMedico;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroPaciente;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import com.GabrielOkumura.agendamento_consultas.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico) {
        repository.save( new Medico(dadosCadastroMedico));
    }
}
