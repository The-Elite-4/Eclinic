package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Secretary;
import com.example.Eclinic.repositories.*;
import org.hibernate.event.spi.SaveOrUpdateEvent;
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
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    SubAdminRepo subAdminRepo;

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

    @GetMapping ("/deleteSecretary/{id}")
    public RedirectView deleteSecretary(@PathVariable Integer id){
        secretaryRepo.deleteById(id);
        return new RedirectView("/subAdminPanel");
    }

    // for edit secretary modal
    @GetMapping("/getSecretary/{id}")
    public String getOneDoctor(@PathVariable Integer id, Model m,Principal p){
        Integer clinicID = subAdminRepo.findByUsername(p.getName()).getClinic().getId();
        m.addAttribute("secretaries", secretaryRepo.findAllByClinicIdOrderByIdAsc(clinicID));
        m.addAttribute("doctors", doctorRepo.findAllByClinicIdOrderByIdAsc(clinicID));
        m.addAttribute("doctor", new Doctor());
        m.addAttribute("secretary", new Secretary());
        ////////////////////////////
        m.addAttribute("oneSecretary",secretaryRepo.findById(id).get());
        m.addAttribute("showSec",true);
        return "subAdmindashboard.html";
    }

    //// save edited secretary modal
    @PostMapping("/editSecretary/{id}")
    public RedirectView addSomeone2(Principal p, @ModelAttribute Secretary secretary,@PathVariable Integer id){
        Clinic clinic = subAdminRepo.findByUsername(p.getName()).getClinic();
        //////////// set new records
        Secretary oldSec = secretaryRepo.findById(id).get();
        oldSec.setPassword(bCryptPasswordEncoder.encode(secretary.getPassword()));
        oldSec.setFirstName(secretary.getFirstName());
        oldSec.setLastName(secretary.getLastName());
        oldSec.setGender(secretary.getGender());
        oldSec.setPhoneNumber(secretary.getPhoneNumber());
        oldSec.setUsername(secretary.getUsername());
        oldSec.setProfilePic(secretary.getProfilePic());
        secretaryRepo.save(oldSec);
        return new RedirectView("/subAdminPanel");
    }
}
