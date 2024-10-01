package com.GabrielOkumura.agendamento_consultas.repository;

import com.GabrielOkumura.agendamento_consultas.model.Agendamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long > {

    Page<Agendamento> findByAtivoTrue(Pageable pageable);
}
