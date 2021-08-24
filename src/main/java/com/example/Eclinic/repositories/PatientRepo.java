package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient,Integer> {
//    public Patient findByUsername (String username);

}
