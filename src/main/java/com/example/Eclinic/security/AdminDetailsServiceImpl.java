package com.example.Eclinic.security;

import com.example.Eclinic.models.Admin;
import com.example.Eclinic.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = adminRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("The user ("+username+") not found");
        }
        return user;
    }
}
