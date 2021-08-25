package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Prescription;
import com.example.Eclinic.repositories.MedicineRepo;
import com.example.Eclinic.repositories.PatientRepo;
import com.example.Eclinic.repositories.PrescriptionRepo;
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
    @Autowired
    PrescriptionRepo prescriptionRepo;
    @Autowired
    MedicineRepo medicineRepo;

    @GetMapping("/patient/{id}")
    public String getASpecificPatient(@PathVariable Integer id, Model m){
        Patient patient = patientRepo.findById(id).get();
        m.addAttribute("patient", patient);

        //// for sort
        m.addAttribute("byId", Comparator.comparing(Prescription::getId));

        return "singlepatient.html";
    }

    @GetMapping("/getPatient/{id}")
    public String getThePatientUpdateForm(@PathVariable Integer id, Model m, Principal p){
        Integer clinicID = secretaryRepo.findByUsername(p.getName()).getClinic().getId();
        m.addAttribute("patients", patientRepo.findAllByClinicIdOrderByIdAsc(clinicID));
        m.addAttribute("patient", new Patient());
        m.addAttribute("onePatient", patientRepo.findById(id).get());
        m.addAttribute("show", true);
        return "secretarydashboard.html";
    }


    @PostMapping("/addPatient")
    public RedirectView addPatient(Principal p, @ModelAttribute Patient patient){
        Clinic clinic = secretaryRepo.findByUsername(p.getName()).getClinic();
        patient.setClinic(clinic);
        patientRepo.save(patient);
        return new RedirectView("/secretary");
    }

    @GetMapping ("/deletePatient/{id}")
    public RedirectView deleteSecretary(@PathVariable Integer id){
        patientRepo.deleteById(id);
        return new RedirectView("/secretary");
    }

    @PostMapping("/editPatient/{id}")
    public RedirectView addSomeone2(Principal p, @ModelAttribute Patient patient, @PathVariable Integer id){
        Clinic clinic = secretaryRepo.findByUsername(p.getName()).getClinic();
        //////////// set new records

        Patient oldPatient = patientRepo.findById(id).get();
        oldPatient.setFirstName(patient.getFirstName());
        oldPatient.setLastName(patient.getLastName());
        oldPatient.setAge(patient.getAge());
        oldPatient.setPhoneNumber(patient.getPhoneNumber());
        oldPatient.setWeight(patient.getWeight());
        oldPatient.setGender(patient.getGender());
        patientRepo.save(oldPatient);
        return new RedirectView("/secretary");
    }



}
