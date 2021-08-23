package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Secretary;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepo extends CrudRepository<Doctor,Integer> {
    public Doctor findByUsername(String username);
    public Iterable<Doctor> findAllByClinicId(Integer clinicId);
}
