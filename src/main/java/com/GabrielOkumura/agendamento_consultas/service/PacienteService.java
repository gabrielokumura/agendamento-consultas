package com.GabrielOkumura.agendamento_consultas.service;

import com.GabrielOkumura.agendamento_consultas.model.Paciente;
import com.GabrielOkumura.agendamento_consultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public default PacienteDTO findById(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
        return new PacienteDTO(paciente);
    }

    public default PacienteDTO save(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        Paciente salvo = pacienteRepository.save(paciente);
        return new PacienteDTO(salvo);
    }
}
