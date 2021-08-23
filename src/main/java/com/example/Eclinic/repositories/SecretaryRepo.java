package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Secretary;
import com.example.Eclinic.models.SubAdmin;
import org.springframework.data.repository.CrudRepository;

public interface SecretaryRepo extends CrudRepository<Secretary,Integer> {
    public Secretary findByUsername (String username);
    public Iterable<Secretary> findAllByClinicId(Integer clinicId);
}
