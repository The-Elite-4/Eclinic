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
import java.util.ArrayList;
import com.example.Eclinic.models.Clinic;
import com.example.Eclinic.repositories.DoctorRepo;
import com.example.Eclinic.repositories.SecretaryRepo;
import com.example.Eclinic.repositories.SubAdminRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;



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


    @GetMapping("/deleteDoctor/{id}")
    public RedirectView deleteDoctor(@PathVariable Integer id){
        doctorRepo.deleteById(id);
        return new RedirectView("/subAdminPanel");
    }

    @PostMapping("/editDoctor")
    public RedirectView addSomeone(Principal p, @ModelAttribute Doctor doctor){

        Clinic clinic = subAdminRepo.findByUsername(p.getName()).getClinic();
        doctor.setClinic(clinic);
        doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
        doctorRepo.save(doctor);
        return new RedirectView("/subAdminPanel");
    }

    // for edit doctor modal
    @GetMapping("/getDoctor/{id}")
    public String getOneDoctor(@PathVariable Integer id, Model m){
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiii");
        System.out.println(id);

        m.addAttribute("secretaries", secretaryRepo.findAll());
        m.addAttribute("doctors", doctorRepo.findAll());
        m.addAttribute("doctor", new Doctor());
        m.addAttribute("secretary", new Secretary());
        ////////////////////////////
        m.addAttribute("oneDoctor",doctorRepo.findById(id).get());
        m.addAttribute("show",true);
        return "subAdmindashboard.html";
    }

}

