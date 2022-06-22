package com.clinicadental.clinica.repository.impl;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.repository.configuration.ConfigurationJDBC;
import com.clinicadental.clinica.model.Domicilio;
import com.clinicadental.clinica.model.Paciente;
import com.clinicadental.clinica.util.Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteDaoH2 implements IDao<Paciente> {
    private final static Logger log = Logger.getLogger(PacienteDaoH2.class);
    private final static String SQL_INSERT = "INSERT INTO pacientes (apellido, nombre, dni, fecha_ingreso, domicilio_id) VALUES (?,?,?,?,?);";

    private final static String SQL_DELETE = "DELETE FROM pacientes WHERE id=?;";

    private final static String SQL_SELECT = "SELECT * FROM pacientes WHERE id=?";

    private final static String SQL_UPDATE = "UPDATE pacientes SET apellido=?, nombre=?, dni=?, fecha_ingreso=?, domicilio_id=?  WHERE id=?;";
    private final static String SQL_SEARCH = "SELECT * FROM pacientes";

    private final static DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();

    public Paciente registrar(Paciente paciente) {
        log.info("Registrando paciente");
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        try {
            Domicilio domicilio = domicilioDaoH2.registrar(paciente.getDomicilio());
            int id_domicilio = domicilio.getId();
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getApellido());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getDni());
            ps.setDate(4, Util.utilDateToSqlDate(paciente.getFechaIngreso()));
            ps.setInt(5, id_domicilio);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getInt(1));
            ps.close();
            log.info("Paciente registrado: " + paciente);
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }

        return paciente;
    }

    @Override
    public Paciente buscarPorId(int id) {
        log.info("Buscando paciente");
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        Paciente paciente = null;
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                paciente = crearPaciente(rs);
                log.info("Paciente con id " + id + " encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }
        return paciente;
    }

    @Override
    public boolean eliminarPorId(int id) {
        log.info("Elimnando paciente");
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        boolean result = false;
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            result = true;
            log.info("Paciente con id " + id + " eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }

        return result;
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        PreparedStatement ps = null;
        try {
            log.info("Modificando paciente");
            ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
            Domicilio domicilio = domicilioDaoH2.modificar(paciente.getDomicilio());
            ps = configurationJDBC.connectWithDB().prepareStatement(SQL_UPDATE);
            ps.setString(1, paciente.getApellido());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getDni());
            ps.setDate(4, Util.utilDateToSqlDate(paciente.getFechaIngreso()));
            ps.setInt(5, paciente.getDomicilio().getId());
            ps.setInt(6, paciente.getId());
            ps.executeUpdate();
            log.info("Domicilio del paciente modificado.");
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos(){
        log.info("Buscando todos los pacientes");
        List<Paciente> pacientes = new ArrayList<>();
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        Paciente paciente = null;
        try {
            Statement st = configurationJDBC.connectWithDB().createStatement();
            ResultSet rs = st.executeQuery(SQL_SEARCH);
            while(rs.next()){
                paciente = crearPaciente(rs);
                pacientes.add(paciente);
            }
            log.info("Pacientes encontrados: " + pacientes);

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }
        return pacientes;
    }

    private Paciente crearPaciente(ResultSet rs) throws SQLException {
        Paciente paciente = null;
        int idPaciente = rs.getInt(1);
        String apellido = rs.getString(2);
        String nombre = rs.getString(3);
        String dni = rs.getString(4);
        Date fechaIngreso = rs.getDate(5);
        int idDomicilio = rs.getInt(6);
        Domicilio domicilio = domicilioDaoH2.buscarPorId(idDomicilio);
        paciente = new Paciente(idPaciente, apellido, nombre, dni, fechaIngreso, domicilio);

        return paciente;
    }
}
