package com.GabrielOkumura.agendamento_consultas.controller;

import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroPaciente;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemMedico;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemPaciente;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import com.GabrielOkumura.agendamento_consultas.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente) {
        repository.save(new Paciente(dadosCadastroPaciente));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente :: new);
    }

    // Outros endpoints...
}
