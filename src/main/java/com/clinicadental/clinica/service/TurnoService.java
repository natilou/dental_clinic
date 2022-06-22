package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Turno;
import com.clinicadental.clinica.repository.impl.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    public Turno registrar(Turno turno) {
        turno.setFecha(new Date());
        return iTurnoRepository.save(turno);
    }

    public void eliminar(Long id) {
        iTurnoRepository.deleteById(id);
    }

    public Optional<Turno> buscarPorId(Long id) {
        return iTurnoRepository.findById(id);
    }

    public List<Turno> buscarTodos() {
        return iTurnoRepository.findAll();
    }

    public Turno actualizar(Turno turno) {
        return iTurnoRepository.save(turno);
    }
}