package com.GabrielOkumura.agendamento_consultas.dto;

import com.GabrielOkumura.agendamento_consultas.model.Agendamento;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class DadosListagemAgendamento{
        private Long id;
        private LocalDateTime dataHoraAgendamento;

        private Status status;
        private String nomeMedico;
        private String nomePaciente;



        public DadosListagemAgendamento(Agendamento agendamento) {
                this.status = agendamento.getStatus();
                this.id = agendamento.getId();
                this.dataHoraAgendamento = agendamento.getDataAgendamento();
                this.nomeMedico = agendamento.getMedico().getNome();
                this.nomePaciente = agendamento.getPaciente().getNomme();
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public LocalDateTime getDataHoraAgendamento() {
                return dataHoraAgendamento;
        }

        public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
                this.dataHoraAgendamento = dataHoraAgendamento;
        }

        public String getNomeMedico() {
                return nomeMedico;
        }

        public void setNomeMedico(String nomeMedico) {
                this.nomeMedico = nomeMedico;
        }

        public String getNomePaciente() {
                return nomePaciente;
        }

        public void setNomePaciente(String nomePaciente) {
                this.nomePaciente = nomePaciente;
        }


}
