package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface IDentistService {

    Dentist save(Dentist dentist);

    Optional<Dentist> findById(Long id);

    void deleteById(Long id);

    Dentist update(Dentist dentist);

    List<Dentist> findAll();
}
