package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PatientRepo extends CrudRepository<Patient,Integer> {
//    public Patient findByUsername (String username);
public Iterable<Patient> findAllByClinicIdOrderByIdAsc(Integer clinicId);
public Set<Patient> findByPrescriptionId(Integer prescriptionId);
}
