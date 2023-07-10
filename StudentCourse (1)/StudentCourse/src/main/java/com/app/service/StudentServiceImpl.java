package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.StudentRequestDto;
import com.app.dto.StudentResponseDto;
import com.app.dto.StudentUpdateDto;
import com.app.entity.Courses;
import com.app.entity.Student;
import com.app.exception.CustomException;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<StudentResponseDto> getAllStudent() {

		List<StudentResponseDto> dto = new ArrayList<>();
		studentRepo.findAll().forEach((v) -> {
			System.out.println(v);
			dto.add(mapper.map(v, StudentResponseDto.class));
		});

		return dto;
	}

	@Override
	public ApiResponse addStudent(StudentRequestDto stud) {
		Student student = new Student(stud.getFirstName(), stud.getLastName(), stud.getDob(), stud.getCourseName());
		courseRepo.findById(stud.getCourse_id()).map((course) -> {
			student.setCourse(course);
			return studentRepo.save(student);
		}).orElseThrow(() -> new CustomException("Student cannot be added"));
		return new ApiResponse("Student added");
	}

	@Override
	public ApiResponse updateStudent(StudentUpdateDto stud) {
		Student student = new Student(stud.getFirstName(), stud.getLastName(), stud.getDob(), stud.getCourseName());
		student.setId(stud.getId());
		courseRepo.findById(stud.getCourse_id()).map((course) -> {
			student.setCourse(course);
			return studentRepo.save(student);
		}).orElseThrow(() -> new CustomException("Student cannot be added"));
		return new ApiResponse("Student Updated");
	}

	@Override
	public List<StudentResponseDto> findByCourse(StudentRequestDto stud) {
		Courses c = courseRepo.findById(stud.getCourse_id()).orElseThrow(()->new CustomException("Course  not found"));
		List<StudentResponseDto> dto = new ArrayList<>();
		studentRepo.findByCourse(c).forEach((v)->{dto.add(mapper.map(v,StudentResponseDto.class));});;
		return dto;
	}

}
