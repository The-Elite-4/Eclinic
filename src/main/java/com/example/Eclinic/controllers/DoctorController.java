package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.repositories.DoctorRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class DoctorController {

    // abdallah

    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    SubAdminRepo subAdminRepo;
   @Autowired
   BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/deleteDoctor/{id}")
    public RedirectView deleteDoctor(@PathVariable Integer id){
        doctorRepo.deleteById(id);
        return new RedirectView("/subAdminPanel");
    }

    @PostMapping("/editDoctor")
    public RedirectView addSomeone(Principal p, @ModelAttribute Doctor doctor){

        Clinic clinic = subAdminRepo.findByUsername(p.getName()).getClinic();
        doctor.setClinic(clinic);
        doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
        doctorRepo.save(doctor);
        return new RedirectView("/subAdminPanel");
    }

}

