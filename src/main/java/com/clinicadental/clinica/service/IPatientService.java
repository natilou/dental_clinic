package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    Patient save(Patient patient);

    Optional<Patient> findById(Long id);

    void deleteById(Long id);

    Patient update(Patient patient);

    List<Patient> findAll();
}
