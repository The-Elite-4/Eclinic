package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepo extends CrudRepository<Doctor,Integer> {
    public Doctor findByUsername(String username);
}
