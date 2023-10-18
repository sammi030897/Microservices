package com.patientservice.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientservice.api.entity.Patient;
import com.patientservice.api.repository.PatientRepository;

@Service
public class PatientService {

	private PatientRepository patientRepo;

	@Autowired
	public PatientService(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}

	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	public List<Patient> getAllPatients(){
		return patientRepo.findAll();
	}
	
	public void deletePatient(Long id) {
		patientRepo.deleteById(id);
	}

	public Optional<Patient> getPatientById(Long id) {
	    // Assuming that patientRepository is used to interact with your database
	    Optional<Patient> patient = patientRepo.findById(id);
	    return patient;
	}

}
