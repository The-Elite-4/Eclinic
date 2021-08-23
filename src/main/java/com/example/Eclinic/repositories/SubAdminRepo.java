package com.example.Eclinic.repositories;

import com.example.Eclinic.models.SubAdmin;
import org.springframework.data.repository.CrudRepository;

public interface SubAdminRepo extends CrudRepository<SubAdmin,Integer> {
    public SubAdmin findByUsername (String username);
    public Iterable<SubAdmin> findAllByIsEnabled (boolean isEnabled);
}
