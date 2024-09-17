package com.GabrielOkumura.agendamento_consultas.controller;

import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroPaciente;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import com.GabrielOkumura.agendamento_consultas.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente) {
        repository.save(new Paciente(dadosCadastroPaciente));
    }

    // Outros endpoints...
}
