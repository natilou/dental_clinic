package com.clinicadental.clinica.controller;
import com.clinicadental.clinica.exceptions.BadRequestException;
import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
import com.clinicadental.clinica.model.Appointment;
import com.clinicadental.clinica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;


    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(appointmentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws ResourceNotFoundException {
        appointmentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> findAll(){
        return ResponseEntity.ok(appointmentService.findAll());
    }


    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @PutMapping
    public ResponseEntity<Appointment> update(@RequestBody Appointment appointment) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(appointmentService.update(appointment));
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> manageErrorBadRequest(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}