package com.example.Eclinic.controllers;

import com.example.Eclinic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import com.example.Eclinic.repositories.DoctorRepo;
import com.example.Eclinic.repositories.PatientRepo;
import com.example.Eclinic.repositories.PrescriptionRepo;


@Controller
public class PrescriptionController {
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
    @Autowired
    MedicineRepo medicineRepo;

    @Autowired
    PatientRepo patientRepo;

    @GetMapping("/deletePersc/{perscId}/{patientId}")
    public RedirectView deletePersc(@PathVariable(value = "perscId") Integer perscId, @PathVariable(value =
            "patientId") Integer patientId) {

        prescriptionRepo.delete(prescriptionRepo.findById(perscId).get());
        return new RedirectView("/patient/" + patientId);
    }
}
