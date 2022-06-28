package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.service.AddressService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void TestSave(){
        Address address = new Address("Jacaranda", 709, "Las Heras", "Mendoza");
        Assertions.assertNotNull(addressService.save(address));
    }

    /*@Test
    public void testEliminar() {
        addressService.deleteById(26L);
        Assertions.assertNull(addressService.findById(26L));
    }*/

    @Test
    public void TestFindAll(){
        Assertions.assertNotNull(addressService.findAll());
    }

    @Test
    public void TestFindById(){
        Assertions.assertNotNull(addressService.findById(21L));
    }
}


