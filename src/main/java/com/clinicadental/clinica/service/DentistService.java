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

    public Dentist  findById(Long id){
        Dentist dentist = null;
        Optional<Dentist> optionalDentist = iDentistRepository.findById(id);
        if (optionalDentist.isPresent()){
            dentist = optionalDentist.get();
        }
        return dentist;
    }

    public boolean deleteById(Long id){
        boolean result = false;
        try{
            iDentistRepository.deleteById(id);
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
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
