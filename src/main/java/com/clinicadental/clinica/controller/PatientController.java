package com.clinicadental.clinica.controller;


import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")

public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public Optional<Patient> findById(@PathVariable Long id) {
        return patientService.findById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        patientService.deleteById(id);
    }

    @GetMapping
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient) {
        return patientService.update(patient);
    }
}
