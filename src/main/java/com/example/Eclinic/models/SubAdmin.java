package com.example.Eclinic.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.awt.event.ActionListener;
import java.util.Collection;

@Entity
public class SubAdmin implements UserDetails {
    ////////////////////////////////////fields////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String profilePic; //we might make it uploaded
    private String gender;
    private boolean isEnabled;
    // verification fields
    private Integer licenseId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
//    private Clinic clinic;
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    ////////////////////////////////////constructor//////////////////////////////////////

    public SubAdmin() {
    }

    public SubAdmin(String userName, String password, String firstName, String lastName, String profilePic,
                    String gender, Integer licenseId, Clinic clinic) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.gender = gender;
        this.clinic = clinic;
        this.licenseId = licenseId;
        this.isEnabled = false;
    }

    ////////////////////////////////////methods//////////////////////////////////////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return this.isEnabled;
    }
    ////////////////////////////////////setters and getters//////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Integer getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Integer licenseId) {
        this.licenseId = licenseId;
    }
}
