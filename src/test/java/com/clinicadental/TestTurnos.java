package com.clinicadental;

import com.clinicadental.clinica.model.Domicilio;
import com.clinicadental.clinica.model.Odontologo;
import com.clinicadental.clinica.model.Paciente;
import com.clinicadental.clinica.model.Turno;
import com.clinicadental.clinica.repository.impl.TurnoDaoRepository;
import com.clinicadental.clinica.service.TurnoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestTurnos {


    private Date fecha;
    Domicilio domicilio = new Domicilio("Jacaranda", 709, "Las Heras", "Mendoza");
    Paciente paciente = new Paciente("Falcone", "Gino", "502356", new Date(), domicilio);
    Paciente paciente2 = new Paciente("Falcone", "Renzo", "502356", new Date(), domicilio);
    Odontologo odontologo = new Odontologo(1522, "Isabella", "Lopez");

    Turno turno = new Turno(1, paciente, odontologo, new Date());
    Turno turno2 = new Turno(2, paciente2, odontologo, new Date());
    Turno turno3 = new Turno(3, paciente2, odontologo, new Date());
    TurnoService turnoService = new TurnoService(new TurnoDaoRepository());


    @Test
    public void TestRegistrar(){
        //Assertions.assertNotNull(turnoService.registrar(turno));
        //Assertions.assertNotNull(turnoService.registrar(turno2));
        Assertions.assertNotNull(turnoService.registrar(turno3));
    }

    @Test
    public void TestBuscarPorId() {
        Assertions.assertNotNull(turnoService.buscarPorId(1));
    }

    @Test
    public void TestBuscarTodos() {
        Assertions.assertNotNull(turnoService.buscarTodos());
    }

    @Test
    public void TestActualizar() {
        Assertions.assertNotNull(turnoService.actualizar(turno2));
    }

    @Test
    public void TestEliminar() {
        Assertions.assertTrue(turnoService.eliminar(2));
    }

}