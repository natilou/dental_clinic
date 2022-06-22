package com.clinicadental.clinica.service;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.model.Turno;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class TurnoService {

    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public Turno registrar(Turno turno) {
        turno.setFecha(new Date());
        return turnoIDao.registrar(turno);
    }

    public boolean eliminar(Integer id) {
        return turnoIDao.eliminarPorId(id);
    }

    public Turno buscarPorId(Integer id) {
        return turnoIDao.buscarPorId(id);
    }

    public List<Turno> buscarTodos() {
        return turnoIDao.buscarTodos();
    }

    public Turno actualizar(Turno turno) {
        return turnoIDao.modificar(turno);
    }
}