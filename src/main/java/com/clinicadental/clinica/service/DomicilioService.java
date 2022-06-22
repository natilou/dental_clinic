package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Domicilio;
import com.clinicadental.clinica.repository.impl.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    @Autowired
    private IDomicilioRepository iDomicilioRepository;


    public Domicilio registrar(Domicilio domicilio){
        return iDomicilioRepository.save(domicilio);
    }

    public Optional<Domicilio> buscarPorId(Long id){
        return iDomicilioRepository.findById(id);
    }

    public void eliminarPorId(Long id){
        iDomicilioRepository.deleteById(id);
    }

    public Domicilio modificar(Domicilio domicilio){
        return iDomicilioRepository.saveAndFlush(domicilio);
    }

    public List<Domicilio> buscarTodos(){
        return iDomicilioRepository.findAll();
    }
}
