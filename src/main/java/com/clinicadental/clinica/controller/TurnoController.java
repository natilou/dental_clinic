package com.clinicadental.clinica.controller;

import com.clinicadental.clinica.repository.impl.IOdontologoRepository;
import com.clinicadental.clinica.repository.impl.IPacienteRepository;
import com.clinicadental.clinica.repository.impl.ITurnoRepository;
import com.clinicadental.clinica.model.Turno;
import com.clinicadental.clinica.service.OdontologoService;
import com.clinicadental.clinica.service.PacienteService;
import com.clinicadental.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> buscarPorId(@PathVariable Long id){
        if(turnoService.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(turnoService.buscarPorId(id));
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id){
        ResponseEntity<String> response;
        if (turnoService.buscarPorId(id) != null){
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;

    }


    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }


    @PostMapping
    public ResponseEntity<Turno> registrar(@RequestBody Turno odontologo){
        return ResponseEntity.ok(turnoService.registrar(odontologo));
    }

    @PutMapping
    public ResponseEntity<Turno> modificar(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }
}