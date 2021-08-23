package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.Patient;
import com.example.Eclinic.repositories.ClinicRepo;
import com.example.Eclinic.repositories.PatientRepo;
import com.example.Eclinic.repositories.SecretaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class SecretaryController {


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ClinicRepo clinicRepo;

    @Autowired
    SecretaryRepo secretaryRepo;

    @Autowired
    PatientRepo patientRepo;



//    /////Miral/////
//    @GetMapping("/")
//    public String getSecretary(){
////        Clinic clinic = clinicRepo.findById(1).get();
////        Secretary secretary = new Secretary("miral97", "12345", "Miral", "Alabdullah", "female", 017,
////                "https://cdn4.iconfinder.com/data/icons/user-professions-avatar/64/-_employee_female-512.png", clinic);
////        secretary.setPassword(bCryptPasswordEncoder.encode(secretary.getPassword()));
////        secretaryRepo.save(secretary);
//        return "home.html";
//    }



    @GetMapping("/secretary")
    public String getSecretaryDashboard(Model m){
        m.addAttribute("patients", patientRepo.findAll());
        m.addAttribute("patient", new Patient());
        return "secretarydashboard.html";
    }




// abdallah




    @GetMapping ("/deleteSecretary/{id}")
    public RedirectView deleteSecretary(@PathVariable Integer id){
        secretaryRepo.deleteById(id);
        return new RedirectView("/subAdminPanel");
    }

}
