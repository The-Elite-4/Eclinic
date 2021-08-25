package com.example.Eclinic.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clinic {
    ////////////////////////////////////fields////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String address;
    private String description;
    private Integer phoneNumber;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    private String licenseId;
    private String logo;

    @ManyToOne
    private Admin admin;

//    @OneToOne(mappedBy = "clinic")
//    @JoinColumn(name = "subAdmin_id", referencedColumnName = "id")
//    private SubAdmin subAdmin;
    ///////////////////////////////////////// new
    @OneToMany(mappedBy = "clinic",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<SubAdmin> subAdmin = new HashSet<>();
    /////////////////////////////////////////

    @OneToMany(mappedBy = "clinic")
    private Set<Secretary> secretary = new HashSet<Secretary>();

    @OneToMany(mappedBy = "clinic")
    private Set<Doctor> doctor = new HashSet<Doctor>();

    @OneToMany(mappedBy = "clinic")
    private Set<Patient> patient = new HashSet<Patient>();

    ///////////////////////////////////////// constructor ///////////////////////////////////////

    public Clinic() {
    }

    public Clinic(String name, String address, String description, Integer phoneNumber, String licenseId,
                  String logo, Admin admin) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.licenseId = licenseId;
        this.logo = logo;
        this.admin = admin;
    }

    /////////////////////////////////////// setters and getters ////////////////////////////////////
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Set<SubAdmin> getSubAdmin() {
        return subAdmin;
    }

    public void setSubAdmin(Set<SubAdmin> subAdmin) {
        this.subAdmin = subAdmin;
    }

    public Set<Secretary> getSecretary() {
        return secretary;
    }

    public void setSecretary(Set<Secretary> secretary) {
        this.secretary = secretary;
    }

    public Set<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(Set<Doctor> doctor) {
        this.doctor = doctor;
    }

    public Set<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Set<Patient> patient) {
        this.patient = patient;
    }

}
