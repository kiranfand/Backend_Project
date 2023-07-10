package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.CourseRequestDto;
import com.app.dto.CourseResponseDto;
import com.app.dto.CourseUpdateDto;

public interface CourseService{

	List<CourseResponseDto> getAllCourses();
	ApiResponse addCourse(CourseRequestDto course);
	ApiResponse updateCourse(CourseUpdateDto course);
	ApiResponse deleteCourse(Long id);
}
