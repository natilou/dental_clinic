package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IDentistService {
    @Autowired
    private IDentistRepository iDentistRepository;


    public Dentist save(Dentist dentist){

        return iDentistRepository.save(dentist);
    }

    @Override
    public Optional<Dentist> findById(Long id){

        return iDentistRepository.findById(id);
    }

    @Override
    public void deleteById(Long id){

        iDentistRepository.deleteById(id);
    }

    @Override
    public Dentist update(Dentist dentist){
        return iDentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> findAll(){

        return iDentistRepository.findAll();
    }
}
