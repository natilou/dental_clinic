package com.clinicadental.clinica.service;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.model.Paciente;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    private final IDao<Paciente> pacienteDao;

    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente registrar(Paciente paciente){
        return pacienteDao.registrar(paciente);
    }

    public Paciente buscar(int id){
        return pacienteDao.buscarPorId(id);
    }

    public boolean eliminar(int id){
        return pacienteDao.eliminarPorId(id);
    }

    public Paciente modificar(Paciente paciente){
        return pacienteDao.modificar(paciente);
    }

    public List<Paciente> buscarTodos(){
        return pacienteDao.buscarTodos();
    }

}
