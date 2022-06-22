package com.clinicadental;

import com.clinicadental.clinica.repository.impl.PacienteDaoH2;
import com.clinicadental.clinica.model.Domicilio;
import com.clinicadental.clinica.model.Paciente;
import com.clinicadental.clinica.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestPacientes {
    Domicilio domicilio = new Domicilio("Jacaranda", 709, "Las Heras", "Mendoza");
    Paciente paciente = new Paciente("Falcone", "Gino", "502356", new Date(), domicilio);
    Paciente paciente2 = new Paciente("Paura", "Renzo", "1236587", new Date(), domicilio);
    Paciente paciente3 = new Paciente("Paura", "Miguel Angel", "235687", new Date(), domicilio);
    PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @Test
    public void testRegistrar(){
        Assertions.assertNotNull(pacienteService.registrar(paciente));
        Assertions.assertNotNull(pacienteService.registrar(paciente2));
        Assertions.assertNotNull(pacienteService.registrar(paciente3));
    }

    @Test
    public void testEliminar(){
        Assertions.assertTrue(pacienteService.eliminar(4));
    }

    @Test
    public void testBuscarTodos(){
        Assertions.assertTrue(pacienteService.buscarTodos().size() == 8);
    }

    @Test
    public void TestBuscarPorId(){
        Assertions.assertNotNull(pacienteService.buscar(2));
    }
}
