package com.example.Eclinic.models;

import javax.persistence.*;

@Entity
public class SubAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePic; //we might make it uploaded
    private boolean gender;

    @OneToOne(mappedBy = "subAdmin", cascade={CascadeType.ALL})
    private Clinic clinic;

    // verification fields
    private Integer licenseId;

}
