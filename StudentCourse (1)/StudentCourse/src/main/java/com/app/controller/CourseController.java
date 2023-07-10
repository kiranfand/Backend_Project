package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseRequestDto;
import com.app.dto.CourseUpdateDto;
import com.app.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseServ;
	
	
	@GetMapping
	public ResponseEntity<?> getAllCourse(){
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.getAllCourses());
	}
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(@RequestBody @Valid  CourseRequestDto c){
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.addCourse(c));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable Long id,@RequestBody CourseUpdateDto c){
		c.setCourse_id(id);
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.updateCourse(c));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(courseServ.deleteCourse(id));
	}
}
