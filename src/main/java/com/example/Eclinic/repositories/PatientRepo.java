package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Secretary;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PatientRepo extends CrudRepository<Patient,Integer> {
public Iterable<Patient> findAllByClinicIdOrderByIdAsc(Integer clinicId);
public Set<Patient> findByPrescriptionId(Integer prescriptionId);
public Iterable<Patient> findTop5ByClinicIdOrderByIdAsc(Integer clinicId);
}
