package com.clinicadental.clinica.repository.impl;

import com.clinicadental.clinica.repository.IDao;
import com.clinicadental.clinica.repository.configuration.ConfigurationJDBC;
import com.clinicadental.clinica.model.Domicilio;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DomicilioDaoH2 implements IDao<Domicilio> {
    private final static Logger log = Logger.getLogger(PacienteDaoH2.class);
    private final static String SQL_INSERT = "INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES (?,?,?,?);";

    private final static String SQL_DELETE = "DELETE FROM domicilios WHERE id=?;";

    private final static String SQL_SELECT = "SELECT * FROM domicilios WHERE id=?";

    private final static String SQL_UPDATE = "UPDATE domicilios SET calle=?, numero=? ,localidad=?, provincia=?  WHERE id=?;";
    private final static String SQL_SEARCH = "SELECT * FROM domicilios";

    @Override
    public Domicilio registrar(Domicilio domicilio) {
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();
            ResultSet key = ps.getGeneratedKeys();
            if(key.next()){
                domicilio.setId(key.getInt(1));
            }
            ps.close();
            log.info("Domicilio registrado");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarPorId(int id) {
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        Domicilio domicilio = null;
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                domicilio = crearDomicilio(rs);
                log.info("Domicilio encontrado " + domicilio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }
        return domicilio;
    }

    @Override
    public boolean eliminarPorId(int id) {
        log.info("Eliminando domicilio");
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        boolean result = false;
        try {
            PreparedStatement ps = configurationJDBC.connectWithDB().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            result = true;
            log.info("Domicilio con id " + id + " eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }

        return result;
    }

    @Override
    public Domicilio modificar(Domicilio domicilio) {
        PreparedStatement ps = null;
        try {
            log.info("Modificando paciente");
            ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
            ps = configurationJDBC.connectWithDB().prepareStatement(SQL_UPDATE);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.setInt(5, domicilio.getId());
            ps.executeUpdate();
            ps.close();
            log.info("Domicilio modificado: " + domicilio);

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        log.info("Buscando todos los pacientes");
        ConfigurationJDBC configurationJDBC = new ConfigurationJDBC();
        List<Domicilio> domicilios = new ArrayList<>();
        Domicilio domicilio = null;
        try {
            Statement st = configurationJDBC.connectWithDB().createStatement();
            ResultSet rs = st.executeQuery(SQL_SEARCH);
            while(rs.next()){
                domicilio = crearDomicilio(rs);
                domicilios.add(domicilio);
            }
            log.info("Domicilios encontrados: " + domicilios);

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Error en la base de datos", e);
        }
        return domicilios;
    }

    private Domicilio crearDomicilio(ResultSet rs) throws SQLException {
        Domicilio domicilio = null;
        int idDom = rs.getInt(1);
        String calle = rs.getString(2);
        int numero = rs.getInt(3);
        String localidad = rs.getString(4);
        String provincia = rs.getString(5);
        domicilio = new Domicilio(idDom, calle, numero, localidad, provincia);
        return domicilio;
    }
}
