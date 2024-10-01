package com.GabrielOkumura.agendamento_consultas.repository;

import com.GabrielOkumura.agendamento_consultas.dto.DadosCadastroPaciente;
import com.GabrielOkumura.agendamento_consultas.model.Agendamento;
import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findByAtivoTrue(Pageable pageable);
}
