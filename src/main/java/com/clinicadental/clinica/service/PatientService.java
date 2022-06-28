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

    public Patient save(Patient patient){
        patient.setEntryDate(new Date());
        return iPatientRepository.save(patient);
    }


    public Patient findById(Long id){
        Patient patient = null;
        Optional<Patient> optionalPatient= iPatientRepository.findById(id);
        if (optionalPatient.isPresent()){
            patient = optionalPatient.get();
        }
        return patient;
    }


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

    public List<Patient> saveAll(List<Patient> patients) {
        return iPatientRepository.saveAll(patients);
    }

}
