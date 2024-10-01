package com.GabrielOkumura.agendamento_consultas.model;

import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizaAgendamento;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroAgendamento;
import com.GabrielOkumura.agendamento_consultas.dto.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHoraAgendamento;
    private Status status;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    private Boolean ativo;
    @ManyToOne // Relação opcional com Consulta
    @JoinColumn(name = "consulta_id", nullable = true) // Campo que pode ser nulo até que a consulta seja criada
    private Consulta consulta;

    public Agendamento() {

    }
    public Agendamento(DadosCadastroAgendamento dadosCadastroAgendamento) {
        this.dataHoraAgendamento = dadosCadastroAgendamento.dataHoraAgendamento();
        this.status = dadosCadastroAgendamento.status();
        this.ativo = true;
    }

    public void ativarDesativar() {
        this.ativo =! this.ativo;
    }

    public void atualizar(DadosAtualizaAgendamento dadosAtualizaAgendamento) {
        if(dadosAtualizaAgendamento.dataHoraAgendamento() != null){
            this.dataHoraAgendamento = dadosAtualizaAgendamento.dataHoraAgendamento();
        }
        if(dadosAtualizaAgendamento.status() != null){
            this.status = dadosAtualizaAgendamento.status();
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataHoraAgendamento = dataAgendamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
