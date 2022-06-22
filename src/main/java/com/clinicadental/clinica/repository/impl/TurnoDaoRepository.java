package com.clinicadental.clinica.repository.impl;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.model.Turno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoDaoRepository implements IDao<Turno> {

    private List<Turno> turnos = new ArrayList<>();

    @Override
    public Turno registrar(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscarPorId(int id) {
        Turno turnoBuscado = null;
        for (Turno turno : turnos){
            if(turno.getId() == id){
                turnoBuscado = turno;
            }
        }
        return turnoBuscado;
    }

    @Override
    public boolean eliminarPorId(int id) {
        boolean result = false;
        try {
            Turno turno = buscarPorId(id);
            turnos.remove(turno);
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public Turno modificar(Turno turno) {
        int index = -1;
        for (int i = 0; i < turnos.size(); i++) {
            if (turnos.get(i).getId().equals(turno.getId())) {
                index = i;
            }
        }
        turnos.set(index, turno);
        return turno;
    }

}