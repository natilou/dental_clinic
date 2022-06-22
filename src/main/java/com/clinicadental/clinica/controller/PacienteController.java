package com.clinicadental.clinica.controller;


import com.clinicadental.clinica.repository.impl.IPacienteRepository;
import com.clinicadental.clinica.model.Paciente;
import com.clinicadental.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable Long id) {
        return pacienteService.buscar(id);

    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }

    @GetMapping
    public List<Paciente> buscarTodos() {
        return pacienteService.buscarTodos();
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente paciente) {
        return pacienteService.registrar(paciente);
    }

    @PutMapping
    public Paciente modificar(@RequestBody Paciente paciente) {
        return pacienteService.modificar(paciente);
    }
}
