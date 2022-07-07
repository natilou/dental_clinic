package com.clinicadental.clinica.repository;


import com.clinicadental.clinica.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

}
