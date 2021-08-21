package com.example.Eclinic.security;

import com.example.Eclinic.models.SubAdmin;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SubAdminDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SubAdminRepo subAdminRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SubAdmin subAdmin = subAdminRepo.findByUserName(userName);
        if(subAdmin == null){
            throw new UsernameNotFoundException("The user ("+userName+") not found");
        }
        return subAdmin;
    }
}
