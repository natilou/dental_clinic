package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Dentist;
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
    @Autowired
    DentistService dentistService = new DentistService();

    @Test
    public void TestBuscarTodos(){

        List<Dentist> dentistList = new ArrayList<>();
        dentistList.add(dentist1);
        dentistList.add(dentist2);
        dentistList.add(dentist3);
        dentistList.add(dentist4);


        Assertions.assertEquals(dentistList.size(), dentistService.findAll().size());
    }

    @Test
    public void TestBuscarPorId(){
        Assertions.assertNotNull(dentistService.findById(24L));
    }

    /*@Test
    public void TestEliminar(){
        Assertions.assertTrue(odontologoService.eliminar(3L));
    }*/
}
