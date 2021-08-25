package com.example.Eclinic.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class SubAdmin implements UserDetails {
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
    private String gender;
    private boolean isEnabled;
    // verification fields
    private String licenseId;

    private String authority = "SubAdmin";

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
//    private Clinic clinic;
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    ////////////////////////////////////constructor//////////////////////////////////////

    public SubAdmin() {
    }

    public SubAdmin(String username, String password, String firstName, String lastName, String profilePic,
                    String gender, String licenseId, Clinic clinic) {
        this.username = username;
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
        return this.isEnabled;
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

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }
}
