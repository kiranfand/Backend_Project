package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StudentRequestDto {
	@NotBlank(message = "Name column cannot be blank")
	private String firstName;
	private String lastName;
	@NotNull
	private LocalDate dob;
	private String courseName;
	private Long course_id;
}
