package com.example.Eclinic.controllers;

import com.example.Eclinic.models.*;
import com.example.Eclinic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    SecretaryRepo secretaryRepo;

    /////////////////////////////////////// home /////////////////////////////////////////
    @GetMapping("/")
    public String getHomePage(){
        // WARNING WARNING >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> delete this
//        Admin admin = new Admin("Anas","12345","Anas","Alramahi","https://media-exp1.licdn" +
//                ".com/dms/image/C5603AQE5WQzUEDuh3w/profile-displayphoto-shrink_400_400/0/1617614323444?e=1634774400&v=beta&t=HS-HtxM7Mc2i_7cdUcv8dpEwaitTxnH_nYP9zMwqpPM");
//        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
//        adminRepo.save(admin);

//        Secretary secretary = new Secretary("batata","12345", "batata", "batata", "Vegetables", 2131, "fjldasj", clinicRepo.findById(1).get());
//        secretary.setPassword(bCryptPasswordEncoder.encode(secretary.getPassword()));
//        secretaryRepo.save(secretary);

//        Doctor doctor = new Doctor("Berg", "12345", "James", "Berg", "ladsjf", "sldajfla" , "Male", 123,  123, "Back pain", clinicRepo.findById(1).get());
//        doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
//        doctorRepo.save(doctor);


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
    public RedirectView getDashbaordPage(Model model, Principal p,Authentication authentication){

        System.out.println(authentication.getAuthorities().toString());
        if(authentication.getAuthorities().toString().equals("[SubAdmin]"))
            return new RedirectView("/subAdminPanel");
        else if (authentication.getAuthorities().toString().equals("[Doctor]"))
            return new RedirectView("/subAdminPanel");
        else if(authentication.getAuthorities().toString().equals("[Admin]"))
            return new RedirectView("/adminPanel");
        else if(authentication.getAuthorities().toString().equals("[Secretary]"))
        return new RedirectView("/subAdminPanel");
        else return new RedirectView("/login");
    }
}
