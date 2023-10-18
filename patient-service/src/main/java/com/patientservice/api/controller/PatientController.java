package com.patientservice.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.patientservice.api.entity.Patient;
import com.patientservice.api.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

	private PatientService patientService;

	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@PostMapping
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@GetMapping("/{id}")
	public Optional<Patient> getPatientById(@PathVariable Long id) {
	    return patientService.getPatientById(id);
	}
}
