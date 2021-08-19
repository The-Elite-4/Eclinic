package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepo extends CrudRepository<Prescription,Integer> {
}
