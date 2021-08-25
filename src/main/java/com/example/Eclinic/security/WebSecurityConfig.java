package com.example.Eclinic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AdminDetailsServiceImpl userDetailsService;
    @Autowired
    SubAdminDetailsServiceImpl subAdminDetailsServiceImpl;
    @Autowired
    DoctorDetailsServiceImpl doctorDetailsServiceImpl;
    @Autowired
    SecretaryDetailsServiceImpl secretaryDetailsServiceImpl;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(doctorDetailsServiceImpl).passwordEncoder(passwordEncoder());
        auth.userDetailsService(secretaryDetailsServiceImpl).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(subAdminDetailsServiceImpl).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable().authorizeRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().antMatchers("/login","/signup","/","/aboutUs").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").loginProcessingUrl("/perform_login").defaultSuccessUrl("/myDashboard",true).failureUrl("/login?error").and().logout().logoutUrl("/perform_logout").deleteCookies("JSESSIONID");
    }
}