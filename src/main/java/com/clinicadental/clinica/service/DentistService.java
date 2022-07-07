package com.clinicadental.clinica.service;

import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService {
    @Autowired
    private IDentistRepository iDentistRepository;


    public Dentist save(Dentist dentist){
        return iDentistRepository.save(dentist);
    }

    public Dentist findById(Long id) throws ResourceNotFoundException {
        Optional<Dentist> optionalDentist = iDentistRepository.findById(id);
        if(optionalDentist.isEmpty()){
            throw new ResourceNotFoundException("Dentist with id " + id + " does not exist.");
        }
        return optionalDentist.get();
    }

    public boolean deleteById(Long id) throws ResourceNotFoundException {
        if(this.findById(id) == null) {
            throw new ResourceNotFoundException("Dentist with id " + id + " does not exist.");
        }
        iDentistRepository.deleteById(id);
        return true;
    }

    public Dentist update(Dentist dentist) throws ResourceNotFoundException {
        if(this.findById(dentist.getId()) == null){
            throw new ResourceNotFoundException("Dentist with id " + dentist.getId() + " does not exist.");
        }
        return this.save(dentist);
    }

    public List<Dentist> findAll(){

        return iDentistRepository.findAll();
    }

    public List<Dentist> saveAll(List<Dentist> dentists){
        return iDentistRepository.saveAll(dentists);
    }
}
