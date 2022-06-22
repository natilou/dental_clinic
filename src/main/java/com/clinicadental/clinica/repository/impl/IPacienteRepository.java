package com.clinicadental.clinica.repository.impl;


import com.clinicadental.clinica.model.Paciente;
import com.clinicadental.clinica.util.Util;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

}
