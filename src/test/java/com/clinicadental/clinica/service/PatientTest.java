package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.FixMethodOrder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTest {

    Address address = new Address("Jacaranda", 709, "Las Heras", "Mendoza");

    @Autowired
    PatientService patientService = new PatientService();
    @Autowired
    AddressService addressService = new AddressService();

    @Test
    public void testRegistrar(){
        Address address1 = addressService.save(address);
        Patient patient = new Patient("Falcone", "Gino", "502356", new Date(), address1);
        Patient patient2 = new Patient("Paura", "Renzo", "1236587", new Date(), address1);
        Patient patient3 = new Patient("Paura", "Miguel Angel", "235687", new Date(), address1);
        Assertions.assertNotNull(patientService.save(patient));
        Assertions.assertNotNull(patientService.save(patient2));
        Assertions.assertNotNull(patientService.save(patient3));
    }

   /*@Test
    public void testEliminar(){
        Assertions.assertTrue(patientService.deleteById(25L));
    }*/
    @Test
    public void testBuscarTodos(){
        Assertions.assertTrue(patientService.findAll().size() == 10);
    }

    @Test
    public void TestBuscarPorId(){
        Assertions.assertNotNull(patientService.findById(25L));
    }
}
