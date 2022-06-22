package com.clinicadental.clinica.service;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.model.Domicilio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomicilioService {
    private final IDao<Domicilio> domicilioDao;

    public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }

    public Domicilio registrar(Domicilio domicilio){
        return domicilioDao.registrar(domicilio);
    }

    public Domicilio buscarPorId(int id){
        return domicilioDao.buscarPorId(id);
    }

    public boolean eliminarPorId(int id){
        return domicilioDao.eliminarPorId(id);
    }

    public Domicilio modificar(Domicilio domicilio){
        return domicilioDao.modificar(domicilio);
    }

    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }
}
