package com.appointmentservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointmentservice.api.entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
