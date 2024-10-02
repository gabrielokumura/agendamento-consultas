package com.GabrielOkumura.agendamento_consultas.dto;
import com.GabrielOkumura.agendamento_consultas.model.Agendamento;
import com.GabrielOkumura.agendamento_consultas.model.Consulta;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;

import java.time.LocalDateTime;

public class DadosListagemConsulta {

    private Long id;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String descricao;
    private String status;

    private Paciente paciente;

    private Medico medico;

    private Agendamento agendamento;

    public DadosListagemConsulta(Consulta consulta) {
        this.dataHoraInicio = consulta.getDataHoraInicio();
        this.dataHoraFim = consulta.getDataHoraFim();
        this.descricao = consulta.getDescricao();
        this.status = consulta.getStatus();
        this.paciente = consulta.getPaciente();
        this.medico = consulta.getMedico();
        this.agendamento = consulta.getAgendamento();
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
