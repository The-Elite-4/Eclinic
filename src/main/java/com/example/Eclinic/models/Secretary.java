package com.example.Eclinic.models;

import javax.persistence.*;

@Entity
public class Secretary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private boolean gender;
    private Integer phoneNumber;

    private String profilePic; //we might make it uploaded

    @ManyToOne
    private Clinic clinic;
}
