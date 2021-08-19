package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Clinic;
import org.springframework.data.repository.CrudRepository;

public interface ClinicRepo extends CrudRepository<Clinic,Integer> {
}
