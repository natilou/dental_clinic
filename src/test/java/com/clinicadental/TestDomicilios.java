package com.clinicadental;

import com.clinicadental.clinica.repository.impl.DomicilioDaoH2;
import com.clinicadental.clinica.model.Domicilio;
import com.clinicadental.clinica.service.DomicilioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TestDomicilios {
    Domicilio domicilio = new Domicilio("Jacaranda", 709, "Las Heras", "Mendoza");
    DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());


    @Test
    public void testRegistrar(){
        Assertions.assertNotNull(domicilioService.registrar(domicilio));
    }

    @Test
    public void testEliminar(){
        Assertions.assertTrue(domicilioService.eliminarPorId(2));
    }

    @Test
    public void testBuscarTodos(){
        Assertions.assertTrue(domicilioService.buscarTodos().size() == 5);
    }

    @Test
    public void testBuscarPorId(){
        Assertions.assertNotNull(domicilioService.buscarPorId(1));
    }
}


