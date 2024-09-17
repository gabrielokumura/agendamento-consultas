package com.GabrielOkumura.agendamento_consultas.repository;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
