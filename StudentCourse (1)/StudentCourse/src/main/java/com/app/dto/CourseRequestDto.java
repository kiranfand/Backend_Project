package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseRequestDto {
	@NotBlank
	private String courseName;
	private double fees;
}
