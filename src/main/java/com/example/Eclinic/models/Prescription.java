package com.example.Eclinic.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;
    private String nextVisit;
    private String diagnosis;
    private String comment;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @OneToMany(mappedBy = "prescription")
    private Set<Medicine> medicine = new HashSet<Medicine>();


}
