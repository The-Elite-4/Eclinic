package com.example.Eclinic.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {
    ////////////////////////////////////fields////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private Integer phoneNumber;
    private Integer weight;
    private Integer age;
    private String drugAllergies;

    
    @ManyToOne
    private Clinic clinic;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Prescription> prescription = new HashSet<Prescription>();

    ////////////////////////////////////constructor////////////////////////////////////////

    public Patient() {
    }

    public Patient(String firstName, String lastName, String gender, String dateOfBirth, Integer phoneNumber,
                   Integer weight, Integer age, String drugAllergies, Clinic clinic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.weight = weight;
        this.age = age;
        this.drugAllergies = drugAllergies;
        this.clinic = clinic;
    }

    ////////////////////////////////////getters and setters ////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDrugAllergies() {
        return drugAllergies;
    }

    public void setDrugAllergies(String drugAllergies) {
        this.drugAllergies = drugAllergies;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Set<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(Set<Prescription> prescription) {
        this.prescription = prescription;
    }
}
