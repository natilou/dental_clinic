package com.clinicadental.clinica.repository;

import com.clinicadental.clinica.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShiftRepository extends JpaRepository<Shift, Long> {

}