package com.clinicadental.clinica.controller;

import com.clinicadental.clinica.repository.impl.OdontologoDaoH2;
import com.clinicadental.clinica.repository.impl.PacienteDaoH2;
import com.clinicadental.clinica.repository.impl.TurnoDaoRepository;
import com.clinicadental.clinica.model.Turno;
import com.clinicadental.clinica.service.OdontologoService;
import com.clinicadental.clinica.service.PacienteService;
import com.clinicadental.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService = new TurnoService(new TurnoDaoRepository());
    @Autowired
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    @Autowired
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());


    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id){
        Turno turno = turnoService.buscarPorId(id);
        if(turno !=null){
            return ResponseEntity.ok(turno);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id){
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