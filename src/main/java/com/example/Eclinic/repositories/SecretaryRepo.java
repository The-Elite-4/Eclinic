package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Secretary;
import org.springframework.data.repository.CrudRepository;

public interface SecretaryRepo extends CrudRepository<Secretary, Integer> {
    public Secretary findByUsername (String username);
    public Secretary findByCliniId(Integer id);
}
