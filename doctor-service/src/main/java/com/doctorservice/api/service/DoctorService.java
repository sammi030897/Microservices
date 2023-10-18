package com.doctorservice.api.service;

import org.springframework.stereotype.Service;

import com.doctorservice.api.entity.Doctor;
import com.doctorservice.api.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

}

