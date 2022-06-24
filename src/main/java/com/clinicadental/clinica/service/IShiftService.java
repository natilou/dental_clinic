package com.clinicadental.clinica.service;
import com.clinicadental.clinica.model.Shift;
import java.util.List;
import java.util.Optional;

public interface IShiftService {

    Shift save(Shift shift);

    String deleteById(Long id);

    Optional<Shift> findById(Long id);

    List<Shift> findAll();

    Shift update(Shift shift);
}
