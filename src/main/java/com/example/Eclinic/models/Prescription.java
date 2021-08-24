package com.example.Eclinic.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Prescription {
    ////////////////////////////////////fields////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;
    private String nextVisit;
    private String diagnosis;
    private String comment;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @OneToMany(mappedBy = "prescription",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Medicine> medicine = new HashSet<Medicine>();
    //////////////////////////////////// constructor ////////////////////////////////////////

    public Prescription() {
    }

    public Prescription(String nextVisit, String diagnosis, String comment, Doctor doctor,
                        Patient patient) {
        this.nextVisit = nextVisit;
        this.diagnosis = diagnosis;
        this.comment = comment;
        this.doctor = doctor;
        this.patient = patient;
    }

    //////////////////////////////////// setters and getters////////////////////////////////////////


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(String nextVisit) {
        this.nextVisit = nextVisit;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Medicine> getMedicine() {
        return medicine;
    }

    public void setMedicine(Set<Medicine> medicine) {
        this.medicine = medicine;
    }
}
