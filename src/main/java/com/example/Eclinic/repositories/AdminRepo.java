package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Admin;
import com.example.Eclinic.models.SubAdmin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin,Integer> {
    public Admin findByUsername (String username);
}
