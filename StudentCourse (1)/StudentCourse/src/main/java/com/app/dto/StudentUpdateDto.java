package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StudentUpdateDto {

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String courseName;
	private Long course_id;
	
}
