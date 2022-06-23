package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.repository.impl.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private IPatientRepository iPatientRepository;


    public Patient save(Patient patient){
        return iPatientRepository.save(patient);
    }

    public Optional<Patient> findById(Long id){
        return iPatientRepository.findById(id);
    }

    public void deleteById(Long id){
        iPatientRepository.deleteById(id);
    }

    public Patient update(Patient patient){
        return iPatientRepository.save(patient);
    }

    public List<Patient> findAll(){
        return iPatientRepository.findAll();
    }

}
