package com.clinicadental;

import com.clinicadental.clinica.exceptions.BadRequestException;
import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
import com.clinicadental.clinica.model.Address;
import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.model.Patient;
import com.clinicadental.clinica.model.Appointment;
import com.clinicadental.clinica.service.AddressService;
import com.clinicadental.clinica.service.DentistService;
import com.clinicadental.clinica.service.PatientService;
import com.clinicadental.clinica.service.AppointmentService;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AppointmentTest {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    PatientService patientService;
    @Autowired
    DentistService dentistService;
    @Autowired
    AddressService addressService;

    @Test
    public void TestSave() throws BadRequestException {
        Address address = new Address("Scranton", 189, "Pensilvania", "Pensi");
        Patient patient1 = new Patient("Angela", "Martin", "12548996", new Date(), address);
        Patient patientToSave = patientService.save(patient1);
        Dentist dentist = new Dentist(18999, "Juan", "Perez");
        Dentist dentistToSave = dentistService.save(dentist);

        Appointment appointment1 = new Appointment(patientToSave, dentistToSave, new Date());
        Assertions.assertNotNull(appointmentService.save(appointment1));

    }

    @Test
    public void TestFindById() throws ResourceNotFoundException {
        Assertions.assertNotNull(appointmentService.findById(1));
    }

    @Test
    public void TestFindAll() {
        Assertions.assertNotNull(appointmentService.findAll());
    }

    @Test
    public void TestUpdate() throws BadRequestException, ResourceNotFoundException {
        Address address = new Address("Scranton", 189, "Pensilvania", "Pensi");
        Patient patient1 = new Patient("Angela", "Martin", "12548996", new Date(), address);
        Patient patientToSave = patientService.save(patient1);
        Dentist dentist = new Dentist(18999, "Juan", "Perez");
        Dentist dentistToSave = dentistService.save(dentist);
        Dentist dentist2 = new Dentist(1578, "Kevin", "Malone");
        Dentist dentistToSave2 = dentistService.save(dentist2);

        Appointment appointment = new Appointment(patientToSave, dentistToSave, new Date());
        Appointment appointmentSaved = appointmentService.save(appointment);
        appointmentSaved.setDentist(dentistToSave2);
        Assertions.assertNotNull(appointmentService.update(appointmentSaved));
    }

    @Test
    public void TestDeleteById() throws ResourceNotFoundException {
        Assertions.assertTrue(appointmentService.deleteById(102));
        Assertions.assertTrue(appointmentService.deleteById(152));
    }

    @Test
    public void TestGetId() throws BadRequestException {
        Address address = new Address("Scranton", 189, "Pensilvania", "Pensi");
        Patient patient = new Patient("Angela", "Martin", "12548996", new Date(), address);
        Patient patientToSave = patientService.save(patient);
        Dentist dentist = new Dentist(1578, "Kevin", "Malone");
        Dentist dentistToSave = dentistService.save(dentist);

        Appointment appointment = new Appointment(patientToSave, dentistToSave, new Date());
        Appointment appointmentSaved = appointmentService.save(appointment);
        Assertions.assertNotNull(appointmentSaved.getId());
    }

    @Test
    public void TestGetDentistappointment() throws ResourceNotFoundException {
        Appointment appointment = appointmentService.findById(1);
        Assertions.assertNotNull(appointment.getDentist());
    }

    @Test
    public void TestGetPatientappointment() throws ResourceNotFoundException {
        Appointment appointment = appointmentService.findById(1);
        Assertions.assertNotNull(appointment.getPatient());
    }

    @Test
    public void TestGetDateappointment() throws ResourceNotFoundException {
        Appointment appointment = appointmentService.findById(1);
        Assertions.assertNotNull(appointment.getDate());
    }
}