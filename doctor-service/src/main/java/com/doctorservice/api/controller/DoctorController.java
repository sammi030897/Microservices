package com.doctorservice.api.controller;

import org.springframework.web.bind.annotation.*;

import com.doctorservice.api.entity.Doctor;
import com.doctorservice.api.service.DoctorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
  
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

}

