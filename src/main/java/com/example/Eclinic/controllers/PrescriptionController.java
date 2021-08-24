package com.example.Eclinic.controllers;

import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Prescription;
import com.example.Eclinic.repositories.DoctorRepo;
import com.example.Eclinic.repositories.PatientRepo;
import com.example.Eclinic.repositories.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrescriptionController {

    @Autowired
    PrescriptionRepo prescriptionRepo;

    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    PatientRepo patientRepo;

//    @GetMapping("/")
//    public String addPrescription(Model m){
//        Doctor doctor = doctorRepo.findById(2).get();
//        Patient patient = patientRepo.findById(2).get();
//        Prescription prescription = new Prescription("22-10-2021", "another stomachache ", "I don't know",
//                doctor, patient);
//        prescriptionRepo.save(prescription);
//        return "home.html";
//    }





}
