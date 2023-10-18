package com.doctorservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorservice.api.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
