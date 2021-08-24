package com.example.Eclinic.models;

import javax.persistence.*;

@Entity
public class Medicine {
    ////////////////////////////////////fields////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer dosage;
    private String unit;
    private String timesPer;
    private Integer duration;
    private String durationType;
    private String details; // how and when to take medicinine
    private boolean beforeMeals;

    @ManyToOne(cascade = CascadeType.ALL)
    private Prescription prescription;
    ////////////////////////////////////constructor////////////////////////////////////////


    public Medicine() {
    }

    public Medicine(String name, Integer dosage, String unit, String timesPer, Integer duration, String durationType,
                    String details, boolean beforeMeals, Prescription prescription) {
        this.name = name;
        this.dosage = dosage;
        this.unit = unit;
        this.timesPer = timesPer;
        this.duration = duration;
        this.durationType = durationType;
        this.details = details;
        this.beforeMeals = beforeMeals;
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

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
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

    public boolean isBeforeMeals() {
        return beforeMeals;
    }

    public void setBeforeMeals(boolean beforeMeals) {
        this.beforeMeals = beforeMeals;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
