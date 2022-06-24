package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    private IPatientRepository iPatientRepository;


    @Override
    public Patient save(Patient patient){
        return iPatientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Long id){
        return iPatientRepository.findById(id);
    }

    @Override
    public void deleteById(Long id){
        iPatientRepository.deleteById(id);
    }

    @Override
    public Patient update(Patient patient){
        return iPatientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll(){
        return iPatientRepository.findAll();
    }

}
