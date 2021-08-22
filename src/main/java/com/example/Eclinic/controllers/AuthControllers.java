package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Admin;
import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.SubAdmin;
import com.example.Eclinic.repositories.AdminRepo;
import com.example.Eclinic.repositories.ClinicRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.security.Principal;

@Controller
public class AuthControllers {
    ///////////////////////////////////// autowired /////////////////////////////////////
    @Autowired
    SubAdminRepo subAdminRepo;
    @Autowired
    ClinicRepo clinicRepo;
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /////////////////////////////////////// home /////////////////////////////////////////
    @GetMapping("/")
    public String getHomePage(){
        // WARNING WARNING >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> delete this
//        Admin admin = new Admin("Anas","12345","Anas","Alramahi","https://media-exp1.licdn" +
//                ".com/dms/image/C5603AQE5WQzUEDuh3w/profile-displayphoto-shrink_400_400/0/1617614323444?e=1634774400&v=beta&t=HS-HtxM7Mc2i_7cdUcv8dpEwaitTxnH_nYP9zMwqpPM");
//        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
//        adminRepo.save(admin);

        return "home.html";
    }

    //////////////////////////////// main signup and login ////////////////////////////////////////
    @GetMapping("/signup")
    public String getSignupPage(Model model){
        model.addAttribute("subAdmin", new SubAdmin());
        return "signup.html";
    }

    @Transactional
    @PostMapping("/signup")
    public RedirectView addSubAdmin(@ModelAttribute SubAdmin subAdmin, @RequestParam String name,
                                    @RequestParam String address,@RequestParam String description,
                                    @RequestParam Integer phoneNumber,@RequestParam String logo){

        Admin admin = adminRepo.findById(1).get();
        Clinic clinic = new Clinic(name,address,description,phoneNumber, subAdmin.getLicenseId(), logo,admin);
        clinicRepo.save(clinic);

        subAdmin.setPassword(bCryptPasswordEncoder.encode(subAdmin.getPassword()));
        subAdmin.setClinic(clinic);
        subAdminRepo.save(subAdmin);

        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login.html";
    }

    ////////////////////////////////////////// redircet to dashboard page //////////////////////
    @GetMapping("/myDashboard")
    public String getDashbaordPage(Model model, Principal p){

        if(p.getName().contains("SubAdmin"))
            return "subAdmindashboard.html";
        else if (p.getName().contains("Doctor"))
            return "doctordashboard.html";
        else if(p.getName().contains("Admin"))
            return "adminPanel.html";
        else
            return "secretarydashboard.html";
    }
}
