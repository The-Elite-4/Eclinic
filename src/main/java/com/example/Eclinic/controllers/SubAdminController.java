package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Secretary;
import com.example.Eclinic.models.SubAdmin;
import com.example.Eclinic.repositories.DoctorRepo;
import com.example.Eclinic.repositories.SecretaryRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class SubAdminController {

    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    SecretaryRepo secretaryRepo;
    @Autowired
    SubAdminRepo subAdminRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/subAdminPanel")
    public String getSubAdminPage(Model m, Principal p){
        // get all doctors and secretaries
        m.addAttribute("secretaries", secretaryRepo.findAll());
        m.addAttribute("doctors", doctorRepo.findAll());
        m.addAttribute("doctor", new Doctor());
        m.addAttribute("secretary", new Secretary());
        return "subAdmindashboard.html";
    }

    @PostMapping("/addDoctor")
    public RedirectView addSomeone(Principal p, @ModelAttribute Doctor doctor){
        Clinic clinic = subAdminRepo.findByUsername(p.getName()).getClinic();
        doctor.setClinic(clinic);
        doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
        doctorRepo.save(doctor);
        return new RedirectView("/subAdminPanel");
    }

    @PostMapping("/addSecretary")
    public RedirectView addSomeone(Principal p, @ModelAttribute Secretary secretary){
        Clinic clinic = subAdminRepo.findByUsername(p.getName()).getClinic();
        secretary.setClinic(clinic);
        secretary.setPassword(bCryptPasswordEncoder.encode(secretary.getPassword()));
        secretaryRepo.save(secretary);
        return new RedirectView("/subAdminPanel");
    }

}
