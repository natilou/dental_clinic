package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Patient;
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


    public boolean deleteById(Long id) {
        boolean message = false;

        if(iShiftRepository.findById(id).isPresent()){
            iShiftRepository.deleteById(id);
            message = true;
        }
        return message;
    }


    public Shift findById(Long id) {
        Shift shift = null;
        Optional<Shift> optionalShift = iShiftRepository.findById(id);
        if (optionalShift.isPresent()){
            shift = optionalShift.get();
        }
        return shift;
    }


    public List<Shift> findAll() {
        return iShiftRepository.findAll();
    }


    public Shift update(Shift shift) {
        return iShiftRepository.save(shift);
    }
}