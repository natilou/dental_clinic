package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.Shift;
import com.clinicadental.clinica.repository.IShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftService implements IShiftService{


    @Autowired
    private IShiftRepository iShiftRepository;


    @Override
    public Shift save(Shift shift) {
        shift.setDate(new Date());
        return iShiftRepository.save(shift);
    }

    @Override
    public String deleteById(Long id) {
        String message = "Shift with id " + id + "doesn't exist.";

        if(iShiftRepository.findById(id).isPresent()){
            iShiftRepository.deleteById(id);
            message = "Shift with id " + id + "was deleted.";
        }
        return message;
    }

    @Override
    public Optional<Shift> findById(Long id) {
        return iShiftRepository.findById(id);
    }

    @Override
    public List<Shift> findAll() {
        return iShiftRepository.findAll();
    }

    @Override
    public Shift update(Shift shift) {
        return iShiftRepository.save(shift);
    }
}