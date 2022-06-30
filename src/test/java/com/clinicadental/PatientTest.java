package com.clinicadental;

import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.service.AddressService;
import com.clinicadental.clinica.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.FixMethodOrder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientTest {

    Address address = new Address("Jacaranda", 709, "Las Heras", "Mendoza");

    @Autowired
    PatientService patientService = new PatientService();
    @Autowired
    AddressService addressService = new AddressService();

    @Test
    public void TestAddNewPatient(){
        Address address1 = addressService.save(address);
        Patient patient = new Patient("Falcone", "Gino", "502356", new Date(), address1);
        Patient patient2 = new Patient("Paura", "Renzo", "1236587", new Date(), address1);
        Patient patient3 = new Patient("Paura", "Miguel Angel", "235687", new Date(), address1);
        Assertions.assertNotNull(patientService.save(patient));
        Assertions.assertNotNull(patientService.save(patient2));
        Assertions.assertNotNull(patientService.save(patient3));
    }

   @Test
    public void TestDeleteById(){
       patientService.deleteById(1L);
        Assertions.assertTrue(patientService.findById(1L)==null);
    }
    @Test
    public void TestFindAll(){
        Assertions.assertTrue(patientService.findAll().size() == 10);
    }

    @Test
    public void TestFindById(){
        Assertions.assertNotNull(patientService.findById(25L));
    }

    @Test
    public void TestGetId(){
        Patient patient = new Patient("Lopez", "Isabella", "2568799", new Date(), address);
        Patient patientSaved = patientService.save(patient);
        Assertions.assertNotNull(patientSaved.getId());
    }

    @Test
    public void TestGetLastName(){
        Patient patient = patientService.findById(1L);
        Assertions.assertNotNull(patient.getLastName());
    }

    @Test
    public void TestGetFirstName(){
        Patient patient = patientService.findById(1L);
        Assertions.assertNotNull(patient.getFirstName());
    }

    @Test
    public void TestGetDni(){
        Patient patient = patientService.findById(1L);
        Assertions.assertNotNull(patient.getDni());
    }

    @Test
    public void TestGetEntryDate(){
        Patient patient = patientService.findById(1L);
        Assertions.assertNotNull(patient.getEntryDate());
    }

    @Test
    public void TestGetAddress(){
        Patient patient = patientService.findById(1L);
        Assertions.assertNotNull(patient.getAddress());
    }
}
