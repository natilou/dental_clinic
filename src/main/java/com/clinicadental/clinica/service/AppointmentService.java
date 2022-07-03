package com.clinicadental.clinica.service;

import com.clinicadental.clinica.exceptions.BadRequestException;
import com.clinicadental.clinica.exceptions.ResourceNotFoundException;
import com.clinicadental.clinica.model.Appointment;
import com.clinicadental.clinica.repository.IDentistRepository;
import com.clinicadental.clinica.repository.IPatientRepository;
import com.clinicadental.clinica.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {


    @Autowired
    private IAppointmentRepository iAppointmentRepository;
    @Autowired
    private IPatientRepository iPatientRepository;
    @Autowired
    private IDentistRepository iDentistRepository;



    public Appointment save(Appointment appointment) throws BadRequestException {
        if(iPatientRepository.findById(appointment.getPatient().getId()).isEmpty()){
            throw new BadRequestException("Patient does not exist");
        } else if (iDentistRepository.findById(appointment.getDentist().getId()).isEmpty()){
            throw new BadRequestException("Dentist does not exist");
        }
        appointment.setDate(new Date());
        return iAppointmentRepository.save(appointment);
    }

    public boolean deleteById(Integer id) throws ResourceNotFoundException {
        if(this.findById(id) == null){
           throw new ResourceNotFoundException("Appointment with id " + id + " does not exist.");
        }
        iAppointmentRepository.deleteById(id);
        return true;
    }


    public Appointment findById(Integer id) throws ResourceNotFoundException {
        Optional<Appointment> optionalAppointment = iAppointmentRepository.findById(id);
       if(optionalAppointment.isEmpty()){
           throw new ResourceNotFoundException("Appointment with id " + id + " does not exist.");
       };
       return optionalAppointment.get();
    }


    public List<Appointment> findAll() {
        return iAppointmentRepository.findAll();
    }


    public Appointment update(Appointment appointment) throws BadRequestException, ResourceNotFoundException {
        if(this.findById(appointment.getId()) == null){
            throw new ResourceNotFoundException("Appointment with id " + appointment.getId() + " does not exist.");
        }
        return this.save(appointment);
    }
}