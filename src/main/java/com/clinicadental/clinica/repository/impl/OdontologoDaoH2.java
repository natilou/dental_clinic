package com.clinicadental.clinica.repository.impl;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.repository.configuration.ConfigurationJDBC;
import com.clinicadental.clinica.model.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoDaoH2 implements IDao<Odontologo> {
    private final static Logger log = Logger.getLogger(OdontologoDaoH2.class);
    private final static String SQL_INSERT = "INSERT INTO odontologos (nro_matricula, nombre, apellido) VALUES (?,?,?);";
    private final static String SQL_SEARCH = "SELECT * FROM odontologos WHERE id=?;";
    private final static String SQL_SELECT = "SELECT * FROM odontologos;";
    private final static String SQL_DELETE = "DELETE FROM odontologos WHERE id=?;";
    private final static String SQL_UPDATE = "UPDATE odontologos SET nro_matricula=?, nombre=? ,apellido =?  WHERE id=?;";

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        log.info("Registrando odontologo.");
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, odontologo.getNroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();
            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next())
                odontologo.setId(keys.getInt(1));
            ps.close();
            log.info("Ondontologo registrado correctamente: " + odontologo);
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos.", e);
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        log.info("Buscando odontológo con id " + id);
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        Odontologo odontologo = null;
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_SEARCH);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                odontologo = crearOdontologo(rs);
                log.info("Odontologo encontrado: " + odontologo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos.", e);
        }
        return odontologo;
    }

    @Override
    public boolean eliminarPorId(int id) {
        boolean result = false;
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            result = true;
            log.info("Odontologo con id " + id + " eliminado");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos.", e);
        }
        return result;
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        PreparedStatement ps = null;
        try {
            ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
            log.info("Modificando odontologo");
            ps = configurationJDBC.connectWithDB().prepareStatement(SQL_UPDATE);
            ps.setInt(1, odontologo.getNroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.setInt(4, odontologo.getId());
            ps.executeUpdate();
            log.info("Odontologo actualizado: " + odontologo);
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        log.info("Buscando todos los odontologos.");
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologo = null;
        try {
            Statement st = configurationJDBC.connectWithDB().createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT);
            while(rs.next()){
                odontologo = crearOdontologo(rs);
                odontologos.add(odontologo);
            }
            log.info("Todos los odontologos encontrados: " + odontologos);
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos.", e);
        }
        return odontologos;
    }
    private Odontologo crearOdontologo(ResultSet rs) throws SQLException {
        Odontologo odontologo = null;
        int id = rs.getInt(1);
        int nroMatricula = rs.getInt(2);
        String nombre = rs.getString(3);
        String apellido = rs.getString(4);
        odontologo = new Odontologo(id, nroMatricula, nombre, apellido);

        return odontologo;
    }
}


