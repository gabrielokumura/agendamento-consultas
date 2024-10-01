package com.GabrielOkumura.agendamento_consultas.controller;
import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizaAgendamento;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroAgendamento;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemAgendamento;
import com.GabrielOkumura.agendamento_consultas.model.Agendamento;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import com.GabrielOkumura.agendamento_consultas.repository.AgendamentoRepository;
import com.GabrielOkumura.agendamento_consultas.repository.MedicoRepository;
import com.GabrielOkumura.agendamento_consultas.repository.PacienteRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@Tag(name = "teste", description = "teste")
@RequestMapping("agendamento")
public class AgendamentoController {

    private final AgendamentoRepository repository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public AgendamentoController(AgendamentoRepository repository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.repository = repository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAgendamento dadosCadastroAgendamento) {
        Paciente paciente = pacienteRepository.findById(dadosCadastroAgendamento.pacienteID())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dadosCadastroAgendamento.medicoID())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        Agendamento agendamento = new Agendamento(dadosCadastroAgendamento);
        agendamento.setPaciente(paciente);
        agendamento.setMedico(medico);

        repository.save(agendamento);
    }

    @GetMapping
    public Page<DadosListagemAgendamento> listar(Pageable paginacao){
        return repository.findByAtivoTrue(paginacao).map(DadosListagemAgendamento :: new);
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaAgendamento dadosAtualizaAgendamento){
        var agendamento = repository.getReferenceById(dadosAtualizaAgendamento.id());

        Paciente paciente = pacienteRepository.findById(dadosAtualizaAgendamento.pacienteID())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dadosAtualizaAgendamento.medicoID())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        agendamento.setPaciente(paciente);
        agendamento.setMedico(medico);

        agendamento.atualizar(dadosAtualizaAgendamento);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> ativarDesativar(@PathVariable Long id){
        try{
            var agendamento = repository.getReferenceById((id));
            agendamento.ativarDesativar();
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento com o ID " + id + " não encontrado");
        }
    }

}
