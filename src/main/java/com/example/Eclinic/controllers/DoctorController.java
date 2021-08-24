package com.example.Eclinic.controllers;
import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Medicine;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.repositories.DoctorRepo;
import com.example.Eclinic.repositories.SecretaryRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.security.Principal;
import java.util.List;
import java.util.Scanner;


@Controller
public class DoctorController {

    @Autowired
    PatientRepo patientRepo;
    //    // shedule repo
//    @Autowired
    @Autowired
    PrescriptionRepo prescriptionRepo;
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    SubAdminRepo subAdminRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    SecretaryRepo secretaryRepo;


    @GetMapping("/doctorPage")
    public String getDoctorPage(Model m,Principal p) throws FileNotFoundException {
        Integer clinicId = doctorRepo.findByUsername(p.getName()).getClinic().getId();
        m.addAttribute("patients", patientRepo.findTop5ByClinicIdOrderByIdAsc(clinicId));
        // for post
        m.addAttribute("medicine1",new Medicine());
        m.addAttribute("medicine2",new Medicine());
        m.addAttribute("medicine3",new Medicine());
        m.addAttribute("medicine4",new Medicine());
        // send list of medicines from reader
        List<String> allMeds = new ArrayList<String>();
        File file = new File("src/main/resources/med.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
          allMeds.add(scanner.nextLine());
        }
        m.addAttribute("medNames",allMeds);
        return "doctordashboard.html";
    }

    @PostMapping("/addPrescription")
    public RedirectView addPrescription(@ModelAttribute Medicine medicine1,@RequestParam String diagnosis,
                                        @RequestParam String comment, @RequestParam String nextVisit) {
        System.out.println(medicine1.getName());
        System.out.println(medicine1.getDetails());
        System.out.println(diagnosis + ' ' + comment + ' '+ nextVisit);
        System.out.println(medicine1.isBeforeMeals());
        // add patient and doctor objects
        return new RedirectView("/doctorPage");
    }


    @GetMapping("/deleteDoctor/{id}")
    public RedirectView deleteDoctor(@PathVariable Integer id){
        doctorRepo.deleteById(id);
        return new RedirectView("/subAdminPanel");
    }

    //// save edited doctor modal
    @PostMapping("/editDoctor/{id}")
    public RedirectView addSomeone(Principal p, @ModelAttribute Doctor doctor,@PathVariable Integer id){
        Clinic clinic = subAdminRepo.findByUsername(p.getName()).getClinic();
        ////////////set new records
        Doctor oldDoc = doctorRepo.findById(id).get();
        oldDoc.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
        oldDoc.setFirstName(doctor.getFirstName());
        oldDoc.setLastName(doctor.getLastName());
        oldDoc.setDoctorMajor(doctor.getDoctorMajor());
        oldDoc.setGender(doctor.getGender());
        oldDoc.setPhoneNumber(doctor.getPhoneNumber());
        oldDoc.setCertificateId(doctor.getCertificateId());
        oldDoc.setSignatureUrl(doctor.getSignatureUrl());
        oldDoc.setUsername(doctor.getUsername());
        oldDoc.setProfilePic(doctor.getProfilePic());
        doctorRepo.save(oldDoc);
        return new RedirectView("/subAdminPanel");
    }

    // for edit doctor modal
    @GetMapping("/getDoctor/{id}")
    public String getOneDoctor(@PathVariable Integer id, Model m,Principal p){
        Integer clinicID = subAdminRepo.findByUsername(p.getName()).getClinic().getId();
        m.addAttribute("secretaries", secretaryRepo.findAllByClinicIdOrderByIdAsc(clinicID));
        m.addAttribute("doctors", doctorRepo.findAllByClinicIdOrderByIdAsc(clinicID));
        m.addAttribute("doctor", new Doctor());
        m.addAttribute("secretary", new Secretary());
        ////////////////////////////
        m.addAttribute("oneDoctor",doctorRepo.findById(id).get());
        m.addAttribute("show",true);
        m.addAttribute("oneSecretary",new Secretary());
        m.addAttribute("showSec",false);
        return "subAdmindashboard.html";
    }
}

