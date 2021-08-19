package com.example.Eclinic.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePic; //we might make it uploaded
    private String signatureUrl;
    private boolean gender;
    private Integer phoneNumber;


    private Integer certificateId;
    private String doctorRole;

    @ManyToOne
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor")
    private Set<Prescription> prescription = new HashSet<Prescription>();

}
