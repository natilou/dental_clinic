package com.clinicadental.clinica.model;

import javax.persistence.*;

@Entity
@Table(name="odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    private int nroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo() {

    }

    public Odontologo(int nroMatricula, String nombre, String apellido) {
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(Long id, int nroMatricula, String nombre, String apellido) {
        this.id = id;
        this.nroMatricula = nroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(int nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nroMatricula='" + nroMatricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
