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

    private Integer licenseId;
    private String logo;

    @ManyToOne
    private Admin admin;

    @OneToOne
    private SubAdmin subAdmin;

    @OneToMany(mappedBy = "clinic")
    private Set<Secretary> secretary = new HashSet<Secretary>();

    @OneToMany(mappedBy = "clinic")
    private Set<Doctor> doctor = new HashSet<Doctor>();

    @OneToMany(mappedBy = "clinic")
    private Set<Patient> patient = new HashSet<Patient>();



    //don't forget to add the sub admin managing this clinic
    //don't forget the constructor


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
}
