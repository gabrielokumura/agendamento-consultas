package com.GabrielOkumura.agendamento_consultas.repository;
import com.GabrielOkumura.agendamento_consultas.model.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findByAtivoTrue(Pageable pageable);
}
