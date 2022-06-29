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
    @Autowired
    ShiftService shiftService;
    @Autowired
    PatientService patientService;
    @Autowired
    DentistService dentistService;
    @Autowired
    AddressService addressService;

    @Test
    public void TestSave(){
        Address address = new Address("Scranton", 189, "Pensilvania", "Pensi");
        Patient patient1 = new Patient("Angela", "Martin", "12548996", new Date(), address);
        Patient patientToSave = patientService.save(patient1);
        Dentist dentist = new Dentist(18999, "Juan", "Perez");
        Dentist dentistToSave = dentistService.save(dentist);

        Shift shift1 = new Shift(patientToSave, dentistToSave, new Date());
        Assertions.assertNotNull(shiftService.save(shift1));

    }

    @Test
    public void TestFindById() {
        Assertions.assertNotNull(shiftService.findById(1L));
    }

    @Test
    public void TestFindAll() {
        Assertions.assertNotNull(shiftService.findAll());
    }

    @Test
    public void TestUpdate() {
        Address address = new Address("Scranton", 189, "Pensilvania", "Pensi");
        Patient patient1 = new Patient("Angela", "Martin", "12548996", new Date(), address);
        Patient patientToSave = patientService.save(patient1);
        Dentist dentist = new Dentist(18999, "Juan", "Perez");
        Dentist dentistToSave = dentistService.save(dentist);
        Dentist dentist2 = new Dentist(1578, "Kevin", "Malone");
        Dentist dentistToSave2 = dentistService.save(dentist2);

        Shift shift = new Shift(patientToSave, dentistToSave, new Date());
        Shift shiftSaved = shiftService.save(shift);
        shiftSaved.setDentist(dentistToSave2);
        Assertions.assertNotNull(shiftService.update(shiftSaved));
    }

    @Test
    public void TestDeleteById(){
        Assertions.assertTrue(shiftService.deleteById(102L));
        Assertions.assertTrue(shiftService.deleteById(152L));
    }

    @Test
    public void TestGetId(){
        Address address = new Address("Scranton", 189, "Pensilvania", "Pensi");
        Patient patient = new Patient("Angela", "Martin", "12548996", new Date(), address);
        Patient patientToSave = patientService.save(patient);
        Dentist dentist = new Dentist(1578, "Kevin", "Malone");
        Dentist dentistToSave = dentistService.save(dentist);

        Shift shift = new Shift(patientToSave, dentistToSave, new Date());
        Shift shiftSaved = shiftService.save(shift);
        Assertions.assertNotNull(shiftSaved.getId());
    }

    @Test
    public void TestGetDentistShift(){
        Shift shift = shiftService.findById(1L);
        Assertions.assertNotNull(shift.getDentist());
    }

    @Test
    public void TestGetPatientShift(){
        Shift shift = shiftService.findById(1L);
        Assertions.assertNotNull(shift.getPatient());
    }

    @Test
    public void TestGetDateShift(){
        Shift shift = shiftService.findById(1L);
        Assertions.assertNotNull(shift.getDate());
    }
}