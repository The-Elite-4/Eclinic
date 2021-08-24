package com.example.Eclinic.controllers;


import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Prescription;
import com.example.Eclinic.repositories.PatientRepo;
import com.example.Eclinic.repositories.SecretaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Comparator;

@Controller
public class PatientController {

    @Autowired
    PatientRepo patientRepo;
    @Autowired
    SecretaryRepo secretaryRepo;

    @GetMapping("/patient/{id}")
    public String getASpecificPatient(@PathVariable Integer id, Model m){
        Patient patient = patientRepo.findById(id).get();
        m.addAttribute("patient", patient);
        //// for sort
        m.addAttribute("byId", Comparator.comparing(Prescription::getId));
        return "singlepatient.html";
    }

    @PostMapping("/addPatient")
    public RedirectView addPatient(Principal p, @ModelAttribute Patient patient){
        Clinic clinic = secretaryRepo.findByUsername(p.getName()).getClinic();
        patient.setClinic(clinic);
        patientRepo.save(patient);
        return new RedirectView("/secretary");
    }



}
