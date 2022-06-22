package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Odontologo;
import com.clinicadental.clinica.repository.impl.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    public Odontologo registrar(Odontologo odontologo){

        return iOdontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarPorId(Long id){

        return iOdontologoRepository.findById(id);
    }

    public void eliminar(Long id){

        iOdontologoRepository.deleteById(id);
    }

    public Odontologo modificar(Odontologo odontologo){
        return iOdontologoRepository.save(odontologo);
    }

    public List<Odontologo> buscarTodos(){

        return iOdontologoRepository.findAll();
    }
}
