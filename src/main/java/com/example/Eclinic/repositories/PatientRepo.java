package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Secretary;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient,Integer> {
    public Iterable<Patient> findTop5ByClinicIdOrderByIdAsc(Integer clinicId);
}
