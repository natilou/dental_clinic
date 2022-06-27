package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.model.Shift;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiftTest {

/*
    private Date date;
    Address address = new Address("Jacaranda", 709, "Las Heras", "Mendoza");
    Patient patient = new Patient("Falcone", "Gino", "502356", new Date(), address);
    Patient patient2 = new Patient("Falcone", "Renzo", "502356", new Date(), address);
    Dentist dentist = new Dentist(1522, "Isabella", "Lopez");

    Shift turno = new Shift(patient, dentist, new Date());
    Shift turno2 = new Shift(patient2, dentist, new Date());
    Shift turno3 = new Shift(patient2, dentist, new Date());
    @Autowired
    ShiftService shiftService = new ShiftService();


    @Test
    public void TestRegistrar(){
        Assertions.assertNotNull(shiftService.save(turno));
        Assertions.assertNotNull(shiftService.save(turno2));
        Assertions.assertNotNull(shiftService.save(turno3));
    }

    //@Test
    //public void TestBuscarPorId() {
        //Assertions.assertNotNull(turnoService.buscarPorId(1));
    //}

    @Test
    public void TestBuscarTodos() {
        Assertions.assertNotNull(shiftService.findAll());
    }

    @Test
    public void TestActualizar() {
        //Assertions.assertNotNull(turnoService.actualizar(turno2));
    }

*/
}