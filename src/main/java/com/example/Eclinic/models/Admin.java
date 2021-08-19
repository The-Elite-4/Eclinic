package com.example.Eclinic.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePic; //we might make it uploaded

    @OneToMany(mappedBy = "admin")
    private Set<Clinic> clinic = new HashSet<Clinic>();
    //don't forget the constructor and the getters and the setters
}
