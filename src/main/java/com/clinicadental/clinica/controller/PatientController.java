package com.clinicadental.clinica.controller;


import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id) {
        Patient patient = patientService.findById(id);
        if(patient != null){
            return ResponseEntity.ok(patient);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response;
        if(patientService.findById(id) != null){
            patientService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Patient with id " + id + " deleted");
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.save(patient));
    }

    @PutMapping
    public ResponseEntity<Patient> update(@RequestBody Patient patient) {
        if(patientService.findById(patient.getId()) != null) {
            return ResponseEntity.ok(patientService.update(patient));
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Patient>> saveAll(@RequestBody List<Patient> patients){
        return ResponseEntity.ok(patientService.saveAll(patients));
    }
}
