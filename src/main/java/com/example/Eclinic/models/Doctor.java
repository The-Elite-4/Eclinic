package com.example.Eclinic.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class Doctor implements UserDetails {
    ////////////////////////////////////fields////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePic; //we might make it uploaded
    private String signatureUrl;
    private String gender;
    private Integer phoneNumber;

    private Integer certificateId;
    private String doctorMajor;

    private String authority = "Doctor";

    @ManyToOne
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor")
    private Set<Prescription> prescription = new HashSet<Prescription>();


    ////////////////////////////////////constructor//////////////////////////////////////

    public Doctor() {
    }

    public Doctor(String username, String password, String firstName, String lastName, String profilePic,
                  String signatureUrl, String gender, Integer phoneNumber, Integer certificateId, String doctorMajor
            , Clinic clinic) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.signatureUrl = signatureUrl;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.certificateId = certificateId;
        this.doctorMajor = doctorMajor;
        this.clinic = clinic;
    }

    ////////////////////////////////////methods//////////////////////////////////////////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.authority);
        List<SimpleGrantedAuthority> userAuthorities = new ArrayList<>();
        userAuthorities.add(simpleGrantedAuthority);
        return userAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    ////////////////////////////////////setters and getters//////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getSignatureUrl() {
        return signatureUrl;
    }

    public void setSignatureUrl(String signatureUrl) {
        this.signatureUrl = signatureUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getDoctorMajor() {
        return doctorMajor;
    }

    public void setDoctorMajor(String doctorMajor) {
        this.doctorMajor = doctorMajor;
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
