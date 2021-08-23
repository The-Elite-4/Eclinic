package com.example.Eclinic.security;

import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.repositories.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DoctorDetailsServiceImpl implements UserDetailsService {

    @Autowired
    DoctorRepo doctorRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor user = doctorRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("The user ("+username+") not found");
        }
        return user;
    }
}
