package com.clinicadental.clinica.controller;

import com.clinicadental.clinica.model.Shift;
import com.clinicadental.clinica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shifts")
public class ShiftController {

    @Autowired
    private ShiftService shiftService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shift>> findById(@PathVariable Long id){
        if(shiftService.findById(id).isPresent()){
            return ResponseEntity.ok(shiftService.findById(id));
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        ResponseEntity<String> response;
        if (shiftService.findById(id) != null){
            shiftService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;

    }


    @GetMapping
    public ResponseEntity<List<Shift>> findAll(){
        return ResponseEntity.ok(shiftService.findAll());
    }


    @PostMapping
    public ResponseEntity<Shift> save(@RequestBody Shift shift){
        return ResponseEntity.ok(shiftService.save(shift));
    }

    @PutMapping
    public ResponseEntity<Shift> update(@RequestBody Shift shift){
        return ResponseEntity.ok(shiftService.update(shift));
    }
}