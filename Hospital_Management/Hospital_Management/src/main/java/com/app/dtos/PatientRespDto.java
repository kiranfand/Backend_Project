package com.app.dtos;

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
public class PatientRespDto {

	private String patientName;
	private Long mobNumber;
	private String hospitalName;
	private String hospitalAdress;
	private Long hospitalId;
	private Long patientId;
}
