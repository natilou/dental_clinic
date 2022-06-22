package com.clinicadental.clinica.controller;
import com.clinicadental.clinica.model.Odontologo;
import com.clinicadental.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> buscarPorId(@PathVariable Long id){
       if (odontologoService.buscarPorId(id).isPresent()){
           return ResponseEntity.ok(odontologoService.buscarPorId(id));
       } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id){
        ResponseEntity<String> response;
        if (odontologoService.buscarPorId(id) != null){
            odontologoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;

    }


    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }


    @PostMapping
    public ResponseEntity<Odontologo> registrar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrar(odontologo));
    }

    @PutMapping
    public ResponseEntity<Odontologo> modificar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.modificar(odontologo));
    }
}
