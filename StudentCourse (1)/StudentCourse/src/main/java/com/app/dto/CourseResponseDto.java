package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponseDto {

	private Long course_id;
	private String courseName;
	private double fees;
	
}
