package com.clinicadental.clinica.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="shifts")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_sequence")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="paciente_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dentist_id", referencedColumnName = "id")
    private Dentist dentist;
    private Date date;

    public Shift() {
    }

    public Shift(Long id, Patient patient, Dentist dentist, Date date) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    public Shift(Date date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", date=" + date +
                '}';
    }
}