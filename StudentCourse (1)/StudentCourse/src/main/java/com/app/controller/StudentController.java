package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentRequestDto;
import com.app.dto.StudentUpdateDto;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studServ;
	
	@GetMapping
	public ResponseEntity<?> getAllStudents(){
		return ResponseEntity.status(HttpStatus.OK).body(studServ.getAllStudent());
	}
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody @Valid  StudentRequestDto stud){
		return ResponseEntity.status(HttpStatus.OK).body(studServ.addStudent(stud));
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody StudentUpdateDto stud){
		stud.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(studServ.updateStudent(stud));
	}
	
	@GetMapping("/{course_id}")
	public ResponseEntity<?> getByCourse(@PathVariable Long course_id)
	{
		StudentRequestDto dto = new StudentRequestDto();
		dto.setCourse_id(course_id);
		return ResponseEntity.status(HttpStatus.OK).body(studServ.findByCourse(dto));
		
	}
	
}
