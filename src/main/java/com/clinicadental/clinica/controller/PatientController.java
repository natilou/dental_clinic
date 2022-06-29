package com.clinicadental.clinica.controller;


import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.service.PatientService;
import org.apache.coyote.Response;
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
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        Patient patient = patientService.findById(id);
        if(patient != null){
            return ResponseEntity.ok(patient);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        patientService.deleteById(id);
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
        return ResponseEntity.ok(patientService.update(patient));
    }

    @PostMapping("/list")
    public ResponseEntity<List<Patient>> saveAll(@RequestBody List<Patient> patients){
        return ResponseEntity.ok(patientService.saveAll(patients));
    }
}
