package com.clinicadental.clinica.service;

import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
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


    public Patient findById(Long id) throws ResourceNotFoundException {
        Optional<Patient> optionalPatient= iPatientRepository.findById(id);
        if (optionalPatient.isEmpty()){
            throw new ResourceNotFoundException("Patient with id " + id + " does not exist.");
        }
        return optionalPatient.get();
    }


    public boolean deleteById(Long id) throws ResourceNotFoundException {
        if(this.findById(id) == null){
            throw new ResourceNotFoundException("Patient with id " + id + " does not exist.");
        }
        iPatientRepository.deleteById(id);
        return true;
    }

    public Patient update(Patient patient) throws ResourceNotFoundException {
        if(this.findById(patient.getId()) == null){
            throw new ResourceNotFoundException("Patient with id " + patient.getId() + " does not exist.");
        }
        return this.save(patient);
    }

    public List<Patient> findAll(){
        return iPatientRepository.findAll();
    }

    public List<Patient> saveAll(List<Patient> patients) {
        return iPatientRepository.saveAll(patients);
    }

}
