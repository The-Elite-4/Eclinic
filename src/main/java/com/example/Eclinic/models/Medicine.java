package com.example.Eclinic.models;

import javax.persistence.*;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer dosage;
    private String unit;
    private String timesPer;
    private Integer duration;
    private String durationType;
    private String details;
    private boolean beforeMeals;

    @ManyToOne
    private Prescription prescription;


}
