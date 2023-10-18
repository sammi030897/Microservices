package com.appointmentservice.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	
	private long id;
	
	private String name;
	private int age;
	
}
