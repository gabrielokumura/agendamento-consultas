package com.GabrielOkumura.agendamento_consultas.model;

import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizPaciente;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroPaciente;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Paciente")
public class Paciente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;

    public Paciente(){

    }

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente) {

        this.ativo = true;
        this.nome = dadosCadastroPaciente.nome();
        this.email = dadosCadastroPaciente.email();
        this.telefone = dadosCadastroPaciente.telefone();
    }

    public void ativarDesativar() {
        this.ativo =! this.ativo;

    }

    public void atualizar(DadosAtualizPaciente dadosAtualizPaciente) {
        if(dadosAtualizPaciente.nome() != null){
            this.nome = dadosAtualizPaciente.nome();
        }
        if(dadosAtualizPaciente.email() != null){
            this.email = dadosAtualizPaciente.email();
        }
        if(dadosAtualizPaciente.telefone() != null ){
            this.telefone = dadosAtualizPaciente.telefone();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomme() {
        return nome;
    }

    public void setNomme(String nomme) {
        this.nome = nomme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        telefone = telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }



}
