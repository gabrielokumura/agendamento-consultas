package com.GabrielOkumura.agendamento_consultas.model;

import com.GabrielOkumura.agendamento_consultas.dto.DadosAtualizaMedico;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroMedico.DadosCadastroMedico;
import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroMedico.Especialidade;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Medico")
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private String email;

    private Boolean ativo;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;
    public Medico() {
    }

    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.ativo = true;
        this.nome = dadosCadastroMedico.nome();
        this.especialidade = dadosCadastroMedico.especialidade();
        this.email = dadosCadastroMedico.email();
    }

    public void atualizarInformacoes(DadosAtualizaMedico dadosAtualizaMedico) {
        if(dadosAtualizaMedico.nome() != null){
            this.nome = dadosAtualizaMedico.nome();
        }
        if(dadosAtualizaMedico.especialidade() != null ){
            this.especialidade = dadosAtualizaMedico.especialidade();
        }
        if(dadosAtualizaMedico.email() != null ){
            this.email = dadosAtualizaMedico.email();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }



}
