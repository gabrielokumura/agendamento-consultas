package com.GabrielOkumura.agendamento_consultas.model;

import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizaAgendamento;
import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizaConsulta;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroConsulta;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemConsulta;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String descricao;
    private String status;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @OneToOne // Relacionamento com Agendamento
    @JoinColumn(name = "agendamento_id", nullable = false)
    private Agendamento agendamento;

    public Consulta(DadosCadastroConsulta dadosCadastroConsulta) {
        this.ativo = true;
        this.dataHoraInicio = dadosCadastroConsulta.dataHoraInicio();
        this.dataHoraFim = dadosCadastroConsulta.dataHoraFim();
        this.descricao = dadosCadastroConsulta.descricao();
        this.status = dadosCadastroConsulta.status();
    }

    public void atualizar(DadosAtualizaConsulta dadosAtualizaConsulta) {
        if(dadosAtualizaConsulta.dataHoraInicio() != null ){
            this.dataHoraInicio = dadosAtualizaConsulta.dataHoraInicio();
        }
        if(dadosAtualizaConsulta.dataHoraFim() != null){
            this.dataHoraFim = dadosAtualizaConsulta.dataHoraFim();
        }
        if(dadosAtualizaConsulta.descricao() != null){
            this.descricao = dadosAtualizaConsulta.descricao();
        }
        if(dadosAtualizaConsulta.status() != null){
            this.status = dadosAtualizaConsulta.status();
        }
    }

    public void ativarDesativar() {
        this.ativo =! this.ativo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
}
