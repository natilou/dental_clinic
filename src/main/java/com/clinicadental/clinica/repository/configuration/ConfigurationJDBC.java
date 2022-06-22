package com.clinicadental.clinica.repository.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationJDBC {
    private String DB_JDBC_DRIVER;
    private String DB_URL;
    private String DB_USER;
    private String DB_PASSWORD;

    public ConfigurationJDBC(String DB_JDBC_DRIVER, String DB_URL, String DB_USER, String DB_PASSWORD) {
        this.DB_JDBC_DRIVER = DB_JDBC_DRIVER;
        this.DB_URL = DB_URL;
        this.DB_USER = DB_USER;
        this.DB_PASSWORD = DB_PASSWORD;
    }

    public ConfigurationJDBC() {
        this.DB_JDBC_DRIVER = "org.h2.Driver";
        this.DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
        this.DB_USER = "sa";
        this.DB_PASSWORD = "sa";
    }

    public Connection connectWithDB(){
        Connection connection = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
