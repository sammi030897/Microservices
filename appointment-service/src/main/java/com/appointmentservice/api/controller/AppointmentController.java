package com.appointmentservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.appointmentservice.api.entity.Appointment;
import com.appointmentservice.api.payload.Doctor;
import com.appointmentservice.api.payload.Patient;
import com.appointmentservice.api.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	private final AppointmentService appointmentService;
	private final RestTemplate restTemplate;

	@Autowired
	public AppointmentController(RestTemplate restTemplate, AppointmentService appointmentService) {
		this.restTemplate = restTemplate;
		this.appointmentService = appointmentService;
	}

	@PostMapping
	public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
		try {
			ResponseEntity<Patient> patientResponse = restTemplate
					.getForEntity("http://patient-service/patients/" + appointment.getPatientId(), Patient.class);

			if (patientResponse.getStatusCode() != HttpStatus.OK || patientResponse.getBody() == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
			}

			ResponseEntity<Doctor> doctorResponse = restTemplate
					.getForEntity("http://doctor-service/doctors/" + appointment.getDoctorId(), Doctor.class);

			if (doctorResponse.getStatusCode() != HttpStatus.OK || doctorResponse.getBody() == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
			}

			Patient patient = patientResponse.getBody();
			Doctor doctor = doctorResponse.getBody();
			Appointment createdAppointment = appointmentService.createAppointment(appointment);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

}
