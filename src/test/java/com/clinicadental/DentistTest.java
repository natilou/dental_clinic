package com.clinicadental;

import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.service.DentistService;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DentistTest {

    Dentist dentist1 = new Dentist(1522, "Isabella", "Lopez");
    Dentist dentist2 = new Dentist(2366, "Pablo", "Perez");
    Dentist dentist3 = new Dentist(1010, "Gino", "Pascualino");
    Dentist dentist4 = new Dentist(580, "Michael", "Scott");
    Dentist dentist5 = new Dentist(1790, "Miguel", "Angel");
    @Autowired
    DentistService dentistService = new DentistService();

    @Test
    public void TestAddNewDentist(){
        Assertions.assertNotNull(dentistService.save(dentist5));

    }
    @Test
    public void TestFindAll(){
        Assertions.assertNotNull(dentistService.findAll());
    }

    @Test
    public void TestFindById(){
        Assertions.assertNotNull(dentistService.findById(1));
    }

    @Test
    public void TestDeleteById() throws ResourceNotFoundException {
        Assertions.assertTrue(dentistService.deleteById(3));
    }

    @Test
    public void TestGetFirstName(){
        Dentist dentist = dentistService.findById(1);
        Assertions.assertNotNull(dentist.getFirstName());
    }

    @Test
    public void TestGetLastName(){
        Dentist dentist = dentistService.findById(1);
        Assertions.assertNotNull(dentist.getLastName());
    }

    @Test
    public void TestGetRegistrationNumber(){
        Dentist dentist = dentistService.findById(1);
        Assertions.assertNotNull(dentist.getRegistrationNumber());
    }

    @Test
    public void TestGetId(){
        Dentist dentist = new Dentist(15899, "Isabella", "Lopez");
        Dentist dentistSaved = dentistService.save(dentist);
        Assertions.assertNotNull(dentistSaved.getId());
    }
}
