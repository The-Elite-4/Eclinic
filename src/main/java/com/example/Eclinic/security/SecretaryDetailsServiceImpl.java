package com.example.Eclinic.security;

import com.example.Eclinic.models.Secretary;
import com.example.Eclinic.repositories.SecretaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecretaryDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SecretaryRepo secretaryRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Secretary user = secretaryRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("The user ("+username+") not found");
        }
        return user;
    }
}
