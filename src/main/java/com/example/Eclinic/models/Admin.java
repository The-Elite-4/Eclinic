package com.example.Eclinic.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class Admin implements UserDetails {
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
    private String authority = "Admin";

    @OneToMany(mappedBy = "admin",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Clinic> clinic = new HashSet<Clinic>();

    /////////////////////////////////////// constructor ////////////////////////////////////

    public Admin() {
    }

    public Admin(String username, String password, String firstName, String lastName, String profilePic) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
    }

    ///////////////////////////////////////methods//////////////////////////////////////////
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

    ///////////////////////////////////setters and getters//////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String userName) {
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

    public Set<Clinic> getClinic() {
        return clinic;
    }

    public void setClinic(Set<Clinic> clinic) {
        this.clinic = clinic;
    }
}
