package com.example.Eclinic.controllers;


import com.example.Eclinic.models.Admin;
import com.example.Eclinic.models.Admin;
import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.SubAdmin;
import com.example.Eclinic.repositories.AdminRepo;
import com.example.Eclinic.repositories.ClinicRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import com.example.Eclinic.repositories.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;

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

//    //////Miral//////
//    /////////////////////////////////////// home /////////////////////////////////////////
    @GetMapping("/")
    public String getHomePage(Model m){
//         WARNING WARNING >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> delete this
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        if(adminRepo.findAll().toString().equals("[]")){
            Admin admin = new Admin("Anas","12345","Anas","Alramahi","https://media-exp1.licdn" +
                    ".com/dms/image/C5603AQE5WQzUEDuh3w/profile-displayphoto-shrink_400_400/0/1617614323444?e=1634774400&v=beta&t=HS-HtxM7Mc2i_7cdUcv8dpEwaitTxnH_nYP9zMwqpPM");
            admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
            adminRepo.save(admin);
        }

        m.addAttribute("allClinics",clinicRepo.findAll());
        return "home.html";
    }

    @GetMapping("/aboutUs")
    public String getAboutPage(){

        return "about.html";
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
            return new RedirectView("/doctorPage");
        else if(authentication.getAuthorities().toString().equals("[Admin]"))
            return new RedirectView("/adminPanel");
        else if(authentication.getAuthorities().toString().equals("[Secretary]"))
        return new RedirectView("/secretary");
        else return new RedirectView("/");
    }
}
