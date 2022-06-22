package com.clinicadental.clinica.repository.impl;

import com.clinicadental.clinica.repository.configuration.ConfigurationJDBC;
import com.clinicadental.clinica.model.Domicilio;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {

}
