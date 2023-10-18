package com.patientservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientservice.api.entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
