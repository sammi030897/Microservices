package com.appointmentservice.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private Long id;
    private String name;
    private String specialization;

    // Getters and setters
}
