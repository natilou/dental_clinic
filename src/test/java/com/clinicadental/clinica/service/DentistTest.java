package com.clinicadental.clinica.service;

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

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
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
    public void TestBuscarTodos(){
        Assertions.assertNotNull(dentistService.findAll());
    }

    @Test
    public void TestBuscarPorId(){
        Assertions.assertNotNull(dentistService.findById(1L));
    }

    @Test
    public void TestEliminar() {
        Assertions.assertTrue(dentistService.deleteById(3L));
    }
}
