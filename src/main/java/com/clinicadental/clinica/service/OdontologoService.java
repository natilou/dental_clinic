package com.clinicadental.clinica.service;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.model.Odontologo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService {
    private final IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {

        this.odontologoDao = odontologoDao;
    }

    public Odontologo registrar(Odontologo odontologo){

        return odontologoDao.registrar(odontologo);
    }

    public Odontologo buscarPorId(int id){
        return odontologoDao.buscarPorId(id);
    }

    public boolean eliminar(int id){
        return odontologoDao.eliminarPorId(id);
    }

    public Odontologo modificar(Odontologo odontologo){
        return odontologoDao.modificar(odontologo);
    }

    public List<Odontologo> buscarTodos(){

        return odontologoDao.buscarTodos();
    }
}
