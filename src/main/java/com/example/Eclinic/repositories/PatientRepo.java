package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient,Integer> {
//    public Patient findByUsername (String username);
public Iterable<Patient> findAllByClinicIdOrderByIdAsc(Integer clinicId);
public Iterable<Patient> findByPrescriptionId(Integer prescriptionId);
}
