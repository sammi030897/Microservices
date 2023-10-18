package com.appointmentservice.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private Long doctorId;
    private Long patientId;
    
    private LocalDate appointmentDate;

}

