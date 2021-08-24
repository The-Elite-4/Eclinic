package com.example.Eclinic.repositories;

import com.example.Eclinic.models.Doctor;
import com.example.Eclinic.models.Patient;
import com.example.Eclinic.models.Prescription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PrescriptionRepo extends CrudRepository<Prescription,Integer> {
//    public Patient findByPatientId(Integer patientId);
    public Set<Prescription> findPrescriptionIdByDoctorId(Integer id);

}
