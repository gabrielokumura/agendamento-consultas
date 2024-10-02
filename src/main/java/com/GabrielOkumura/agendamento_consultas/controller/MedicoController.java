package com.GabrielOkumura.agendamento_consultas.controller;

import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizaMedico;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroMedico;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemConsulta;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemMedico;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import com.GabrielOkumura.agendamento_consultas.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.Objects;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico) {
        repository.save( new Medico(dadosCadastroMedico));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@RequestParam(value = "status", required = false) String status, Pageable paginacao){
        if (isStrtusInativo(status)) {
            return repository.findAll(paginacao).map(DadosListagemMedico :: new);
        }

        return repository.findByAtivoTrue(paginacao).map(DadosListagemMedico :: new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemMedico> datalhar(@PathVariable Long id){

        return repository.findByIdAndAtivoTrue(id)
                .map(medico -> ResponseEntity.ok(new DadosListagemMedico(medico)))
                .orElse(ResponseEntity.notFound().build());
    }

    private boolean isStrtusInativo(String status){
        return "FALSE".equalsIgnoreCase(status);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaMedico dadosAtualizaMedico){
        var medico = repository.getReferenceById(dadosAtualizaMedico.id());
        medico.atualizarInformacoes(dadosAtualizaMedico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        try{
            var medico = repository.getReferenceById((id));
            medico.ativarDesativar();
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico com o ID " + id + " não encontrado");
        }
    }
}
