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
    public ResponseEntity<Patient> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
        patientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Patient with id " + id + " deleted");
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
    public ResponseEntity<Patient> update(@RequestBody Patient patient) throws ResourceNotFoundException {
        return ResponseEntity.ok(patientService.update(patient));
    }

    @PostMapping("/list")
    public ResponseEntity<List<Patient>> saveAll(@RequestBody List<Patient> patients){
        return ResponseEntity.ok(patientService.saveAll(patients));
    }
}
