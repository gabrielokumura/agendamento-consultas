package com.GabrielOkumura.agendamento_consultas.controller;

import com.GabrielOkumura.agendamento_consultas.dto.*;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import com.GabrielOkumura.agendamento_consultas.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return repository.findByAtivoTrue(paginacao).map(DadosListagemPaciente :: new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizPaciente dadosAtualizPaciente){
        var paciente = repository.getReferenceById(dadosAtualizPaciente.id());
        paciente.atualizar(dadosAtualizPaciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            var paciente = repository.getReferenceById(id);
            paciente.ativarDesativar();

            return ResponseEntity.ok().build();
        } catch (
                EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente com o ID " + id + " não encontrado");
        }

    }
}
