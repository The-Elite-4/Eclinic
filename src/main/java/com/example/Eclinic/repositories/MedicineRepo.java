package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRepo extends CrudRepository<Medicine,Integer> {
}
