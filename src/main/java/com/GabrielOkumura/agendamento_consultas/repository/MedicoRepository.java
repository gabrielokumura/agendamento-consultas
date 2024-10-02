package com.GabrielOkumura.agendamento_consultas.repository;
import com.GabrielOkumura.agendamento_consultas.dto.DadosListagemMedico;
import com.GabrielOkumura.agendamento_consultas.model.Agendamento;
import com.GabrielOkumura.agendamento_consultas.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByAtivoTrue(Pageable pageable);

    Optional<Medico> findByIdAndAtivoTrue(Long id);
}
