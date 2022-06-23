package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DomicilioServiceTest {

    @Autowired
    private AddressService domicilioService;


    @Test
    public void testRegistrar(){
        Address domicilio = new Address("Jacaranda", 709, "Las Heras", "Mendoza");

        Assertions.assertNotNull(domicilioService.save(domicilio));
    }

    /*@Test
    public void testEliminar(){
        Assertions.assertTrue(domicilioService.eliminarPorId(2L));
    }*/

    @Test
    public void testBuscarTodos(){
        Assertions.assertTrue(domicilioService.findAll().size() == 5);
    }

    @Test
    public void testBuscarPorId(){
        Assertions.assertNotNull(domicilioService.findById(1L));
    }
}