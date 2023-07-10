package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.CourseRequestDto;
import com.app.dto.CourseResponseDto;
import com.app.dto.CourseUpdateDto;
import com.app.entity.Courses;
import com.app.exception.CustomException;
import com.app.repository.CourseRepository;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<CourseResponseDto> getAllCourses() {
		List<Courses> c = courseRepo.findAll(); 
		List<CourseResponseDto> dto = new ArrayList<>();
		c.forEach((v)->{dto.add(mapper.map(v,CourseResponseDto.class));});
		return dto;
	}

	@Override
	public ApiResponse addCourse(CourseRequestDto course) {
		Courses c = new Courses(course.getCourseName(),course.getFees());
		courseRepo.save(c);
		return new ApiResponse("Course added");
	}

	@Override
	public ApiResponse updateCourse(CourseUpdateDto course) {
		Courses c = new Courses(course.getCourseName(), course.getFees());
		c.setCourse_id(course.getCourse_id());
		courseRepo.save(c);
		return new ApiResponse("Course updated");
	}

	@Override
	public ApiResponse deleteCourse(Long id) {
		Courses c = courseRepo.findById(id).orElseThrow(()->new CustomException("Course not found"));
		courseRepo.delete(c);
		return new ApiResponse("Course deleted");
	}

}
