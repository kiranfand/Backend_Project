package com.app.dtos;

import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientUpdDto {

	@Max(100)
	private Long id;
	
	private String patientName;
	private Long mobNumber;
}
