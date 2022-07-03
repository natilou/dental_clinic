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

    public Dentist  findById(Integer id){
        Dentist dentist = null;
        Optional<Dentist> optionalDentist = iDentistRepository.findById(id);
        if (optionalDentist.isPresent()){
            dentist = optionalDentist.get();
        }
        return dentist;
    }

    public boolean deleteById(Integer id) throws ResourceNotFoundException {
        if(this.findById(id) == null) {
            throw new ResourceNotFoundException("Dentist with id " + id + " does not exist.");
        }
        iDentistRepository.deleteById(id);
        return true;
    }

    public Dentist update(Dentist dentist){
        return iDentistRepository.save(dentist);
    }

    public List<Dentist> findAll(){

        return iDentistRepository.findAll();
    }

    public List<Dentist> saveAll(List<Dentist> dentists){
        return iDentistRepository.saveAll(dentists);
    }
}
