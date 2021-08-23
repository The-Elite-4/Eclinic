package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Secretary;
import com.example.Eclinic.repositories.DoctorRepo;
import com.example.Eclinic.repositories.SecretaryRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Optional;

@Controller
public class DoctorController {

    // abdallah

    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    SubAdminRepo subAdminRepo;
   @Autowired
   BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    SecretaryRepo secretaryRepo;

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

    // for edit doctor modal
    @GetMapping("/getDoctor/{id}")
    public String getOneDoctor(@PathVariable Integer id, Model m){
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiii");
        System.out.println(id);

        m.addAttribute("secretaries", secretaryRepo.findAll());
        m.addAttribute("doctors", doctorRepo.findAll());
        m.addAttribute("doctor", new Doctor());
        m.addAttribute("secretary", new Secretary());
        ////////////////////////////
        m.addAttribute("oneDoctor",doctorRepo.findById(id).get());
        m.addAttribute("show",true);
        return "subAdmindashboard.html";
    }

}

