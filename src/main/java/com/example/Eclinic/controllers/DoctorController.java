package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Medicine;
import com.example.Eclinic.models.Prescription;
import com.example.Eclinic.models.Secretary;
import com.example.Eclinic.repositories.PatientRepo;
import com.example.Eclinic.repositories.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class DoctorController {

    @Autowired
    PatientRepo patientRepo;
    //    // shedule repo
//    @Autowired
    @Autowired
    PrescriptionRepo prescriptionRepo;

//    @GetMapping("/doctorPage")
//    public String getDoctorPage(Model m){
//        // get
//        m.addAttribute("patients", patientRepo.findAll());
////        m.addAttribute("doctors", sceduleRepo.findAll());
//        // post
//        m.addAttribute("prescription", new Prescription());
//        return "doctordashboard.html";
//    }
//
//    @PostMapping("/addPrescription")
//    public RedirectView addPrescription(@ModelAttribute Prescription prescription){
//
//        //
//
//        // add patient and doctor objects
//        return new RedirectView("/doctorPage");
//    }

    /////////////////////////////////////// TEST ////////////////////////////////
    @GetMapping("/doctorPage")
    public String getDoctorPage(Model m) {
        // get
        m.addAttribute("patients", patientRepo.findAll());
//        m.addAttribute("doctors", sceduleRepo.findAll());
        // post
        ArrayList<Medicine> allmedicines = new ArrayList<>(10);
//        m.addAttribute("allmedicines",allmedicines);
        m.addAttribute("medicine",new Medicine());
        return "doctordashboardTEST.html";
    }

    @PostMapping("/addPrescription")
    public RedirectView addPrescription(@ModelAttribute Medicine medicine) {
        System.out.println(medicine.getName());
        System.out.println(medicine.getDetails());
        System.out.println(medicine.getDurationType());
        System.out.println(medicine.isBeforeMeals());


        // add patient and doctor objects
        return new RedirectView("/doctorPage");
    }
}
