package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Admin;
import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.SubAdmin;
import com.example.Eclinic.repositories.AdminRepo;
import com.example.Eclinic.repositories.ClinicRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {
    ///////////////////////////////  /////////////////////////
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    ClinicRepo clinicRepo;
    @Autowired
    SubAdminRepo subAdminRepo;

    @GetMapping("/adminPanel")
    public String getClinics(Model m, Principal p){

        if(subAdminRepo.findAllByIsEnabled(true) != null){
            m.addAttribute("acceptedSubs" , subAdminRepo.findAllByIsEnabled(true));
        }else{
            m.addAttribute("acceptedSubs" , new SubAdmin());
        }
        if(subAdminRepo.findAllByIsEnabled(false) != null) {
            m.addAttribute("postponedSubs", subAdminRepo.findAllByIsEnabled(false));
        }
        else{
            m.addAttribute("postponedSubs" , new SubAdmin());
        }

        return "adminPanel.html";
    }

    //////////////////////////// This updates the isEnabled field for a subAdmin ////////////////////////////////
    @GetMapping("/acceptSubAdmin/{id}")
    public RedirectView acceptSubAdmin(@PathVariable Integer id){
        SubAdmin subAdmin = subAdminRepo.findById(id).get();
        subAdmin.setEnabled(true);
        subAdminRepo.save(subAdmin);
        return new RedirectView("/adminPanel");
    }
}
