package com.clinicadental.clinica.service;

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

    public Optional<Dentist> findById(Long id){

        return iDentistRepository.findById(id);
    }

    public void deleteById(Long id){

        iDentistRepository.deleteById(id);
    }

    public Dentist update(Dentist dentist){
        return iDentistRepository.save(dentist);
    }

    public List<Dentist> findAll(){

        return iDentistRepository.findAll();
    }
}
