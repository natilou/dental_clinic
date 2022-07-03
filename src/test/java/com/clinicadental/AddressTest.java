package com.clinicadental;

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
import org.springframework.transaction.annotation.Transactional;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AddressTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void TestSave(){
        Address address = new Address("Jacaranda", 709, "Las Heras", "Mendoza");
        Assertions.assertNotNull(addressService.save(address));
    }

    @Test
    public void TestFindAll(){
        Assertions.assertNotNull(addressService.findAll());
    }

    @Test
    public void TestFindById(){
        Assertions.assertNotNull(addressService.findById(21));
    }

    @Test
    public void TestGetId(){
        Address address = new Address("Brooklyn", 99, "Brooklyn", "New York");
        Address addressSaved = addressService.save(address);
        Assertions.assertNotNull(addressSaved.getId());
    }
    @Test
    public void TestGetStreet(){
        Address address = addressService.findById(2).get();
        Assertions.assertNotNull(address.getStreet());
    }

    @Test
    public void TestGetNumber(){
        Address address = addressService.findById(2).get();
        Assertions.assertNotNull(address.getNumber());
    }

    @Test
    public void TestGetLocation(){
        Address address = addressService.findById(2).get();
        Assertions.assertNotNull(address.getLocation());
    }

    @Test
    public void TestGetProvince(){
        Address address = addressService.findById(2).get();
        Assertions.assertNotNull(address.getProvince());
    }

}


