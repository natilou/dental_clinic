package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Shift;
import com.clinicadental.clinica.repository.IDentistRepository;
import com.clinicadental.clinica.repository.IPatientRepository;
import com.clinicadental.clinica.repository.IShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftService {


    @Autowired
    private IShiftRepository iShiftRepository;
    @Autowired
    private IPatientRepository iPatientRepository;
    @Autowired
    private IDentistRepository iDentistRepository;



    public Shift save(Shift shift) {
        Shift shiftToSave = null;
        if(iPatientRepository.findById(shift.getPatient().getId()).isPresent() && iDentistRepository.findById(shift.getDentist().getId()).isPresent()){
            shiftToSave = shift;
            shiftToSave.setDate(new Date());
            return iShiftRepository.save(shiftToSave);
        }
        return shiftToSave;
    }


    public String deleteById(Long id) {
        String message = "Shift with id " + id + "doesn't exist.";

        if(iShiftRepository.findById(id).isPresent()){
            iShiftRepository.deleteById(id);
            message = "Shift with id " + id + "was deleted.";
        }
        return message;
    }


    public Optional<Shift> findById(Long id) {
        return iShiftRepository.findById(id);
    }


    public List<Shift> findAll() {
        return iShiftRepository.findAll();
    }


    public Shift update(Shift shift) {
        return iShiftRepository.save(shift);
    }
}