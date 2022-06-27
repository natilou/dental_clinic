package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService{
    @Autowired
    private IPatientRepository iPatientRepository;

    /* public PatientService(IPatientRepository iPatientRepository) {
        this.iPatientRepository = iPatientRepository;
    }*/

    public Patient save(Patient patient){
        patient.setEntryDate(new Date());
        return iPatientRepository.save(patient);
    }


    public Optional<Patient> findById(Long id){
        return iPatientRepository.findById(id);
    } // también puede ser .get() y devuelve el objeto y no un optional


    public boolean deleteById(Long id){
        boolean message = false;
        try {
            iPatientRepository.deleteById(id);
            message = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

    public Patient update(Patient patient){
        return iPatientRepository.save(patient);
    }

    public List<Patient> findAll(){
        return iPatientRepository.findAll();
    }

}
