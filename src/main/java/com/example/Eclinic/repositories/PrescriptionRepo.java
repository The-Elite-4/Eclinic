package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepo extends CrudRepository<Prescription,Integer> {
//    public Patient findByPatientId(Integer patientId);
    public Prescription findByDoctorId(Integer id);
}
