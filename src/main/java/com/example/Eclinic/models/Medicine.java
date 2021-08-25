package com.example.Eclinic.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Medicine {
    ////////////////////////////////////fields////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dosage;
    private String unit;
    private String timesPer;
    private String duration;
    private String durationType;
    private String details;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Prescription prescription;
    ////////////////////////////////////constructor////////////////////////////////////////

    public Medicine() {
    }

    public Medicine(String name, String dosage, String unit, String timesPer, String duration, String durationType,
                    String details, Prescription prescription) {
        this.name = name;
        this.dosage = dosage;
        this.unit = unit;
        this.timesPer = timesPer;
        this.duration = duration;
        this.durationType = durationType;
        this.details = details;
        this.prescription = prescription;
    }

    ////////////////////////////////////setters and getters ////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTimesPer() {
        return timesPer;
    }

    public void setTimesPer(String timesPer) {
        this.timesPer = timesPer;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
