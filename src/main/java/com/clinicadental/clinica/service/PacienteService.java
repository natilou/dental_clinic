package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Paciente;
import com.clinicadental.clinica.repository.impl.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private IPacienteRepository iPacienteRepository;

    public Paciente registrar(Paciente paciente){
        return iPacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscar(Long id){
        return iPacienteRepository.findById(id);
    }

    public void eliminar(Long id){
        iPacienteRepository.deleteById(id);
    }

    public Paciente modificar(Paciente paciente){
        return iPacienteRepository.save(paciente);
    }

    public List<Paciente> buscarTodos(){
        return iPacienteRepository.findAll();
    }

}
