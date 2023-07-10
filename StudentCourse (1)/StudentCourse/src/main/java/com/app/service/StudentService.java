package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentRequestDto;
import com.app.dto.StudentResponseDto;
import com.app.dto.StudentUpdateDto;

public interface StudentService {

	List<StudentResponseDto> getAllStudent();
	ApiResponse addStudent(StudentRequestDto stud);
	ApiResponse updateStudent(StudentUpdateDto stud);
	List<StudentResponseDto> findByCourse(StudentRequestDto stud);
}
