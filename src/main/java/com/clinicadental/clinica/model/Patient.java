package com.clinicadental.clinica.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    @Column(name = "id")
    private Long id;
    private String lastName;
    private String firstName;
    private String dni;
    private Date entryDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Patient(){

    }
    public Patient(String lastName, String firstName, String dni, Date entryDate, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dni = dni;
        this.entryDate = entryDate;
        this.address = address;
    }

    public Patient(Long id, String lastName, String firstName, String dni, Date entryDate, Address address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dni = dni;
        this.entryDate = entryDate;
        this.address = address;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dni='" + dni + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
