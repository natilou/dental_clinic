package com.clinicadental.clinica.controller;


import com.clinicadental.clinica.repository.impl.PacienteDaoH2;
import com.clinicadental.clinica.model.Paciente;
import com.clinicadental.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    @Autowired
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable Integer id) {
        return pacienteService.buscar(id);

    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Integer id) {
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
