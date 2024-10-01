package com.GabrielOkumura.agendamento_consultas.controller;
import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizaConsulta;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroConsulta;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemConsulta;
import com.GabrielOkumura.agendamento_consultas.model.Agendamento;
import com.GabrielOkumura.agendamento_consultas.model.Consulta;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import com.GabrielOkumura.agendamento_consultas.repository.AgendamentoRepository;
import com.GabrielOkumura.agendamento_consultas.repository.ConsultaRepository;
import com.GabrielOkumura.agendamento_consultas.repository.MedicoRepository;
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

public class ConsultaController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroConsulta dadosCadastroConsulta) {
        Paciente paciente = pacienteRepository.findById(dadosCadastroConsulta.pacienteID())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dadosCadastroConsulta.medicoID())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        Agendamento agendamento = agendamentoRepository.findById(dadosCadastroConsulta.medicoID())
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));

        Consulta consulta = new Consulta(dadosCadastroConsulta);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setAgendamento(agendamento);

        repository.save(consulta);
    }

    @GetMapping
    public Page<DadosListagemConsulta> listar(Pageable paginacao){
        return repository.findByAtivoTrue(paginacao).map(DadosListagemConsulta :: new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaConsulta dadosAtualizaConsulta){
        var consulta = repository.getReferenceById(dadosAtualizaConsulta.id());

        Paciente paciente = pacienteRepository.findById(dadosAtualizaConsulta.pacienteID())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dadosAtualizaConsulta.medicoID())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));


        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        consulta.atualizar(dadosAtualizaConsulta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> ativarDesativar(@PathVariable Long id){
        try{
            var consulta = repository.getReferenceById((id));
            consulta.ativarDesativar();
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta com o ID " + id + " não encontrado");
        }
    }
}
