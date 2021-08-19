package com.example.Eclinic.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private boolean gender;
    private String dateOfBirth;
    private Integer phoneNumber;
    private Integer weight;
    private Integer age;
    private String drugAllergies;

    @ManyToOne
    private Clinic clinic;

    @OneToMany(mappedBy = "patient")
    private Set<Prescription> prescription = new HashSet<Prescription>();

}
