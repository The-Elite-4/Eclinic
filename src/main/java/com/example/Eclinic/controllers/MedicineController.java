package com.example.Eclinic.controllers;

import com.example.Eclinic.repositories.MedicineRepo;
import com.example.Eclinic.repositories.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MedicineController {

    @Autowired
    MedicineRepo medicineRepo;


    @Autowired
    PrescriptionRepo prescriptionRepo;

//    @GetMapping("/")
//    public String addMedicine(){
//        Prescription prescription = prescriptionRepo.findById(3).get();
//        Prescription prescription1 = prescriptionRepo.findById(4).get();
//        Prescription prescription2 = prescriptionRepo.findById(5).get();
//        Medicine medicine = new Medicine("ibuprofen", 325, "460", "3", 2,
//                "daily", "anytime", false, prescription);
//        Medicine medicine1 = new Medicine("Mint", 325, "500", "3", 2,
//                "daily", "anytime", false, prescription);
//        Medicine medicine2 = new Medicine("Mint again", 325, "500", "3", 2,
//                "daily", "anytime", true, prescription);
//        medicineRepo.save(medicine);
//        medicineRepo.save(medicine1);
//        return "home.html";
//    }
}
