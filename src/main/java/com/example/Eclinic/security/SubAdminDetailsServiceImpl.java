package com.example.Eclinic.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SubAdminDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        ApplicationUser user = applicationUserRepository.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("The user ("+username+") not found");
//        }
//        return user;
        return null;
    }
}
