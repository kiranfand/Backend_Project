package com.app.customexcep;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.dtos.AoiRespone;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validMethodArgumentNotValidException(MethodArgumentNotValidException e){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getFieldErrors()
				.stream().collect(Collectors.toMap(f->f.getField(), f->f.getDefaultMessage())));
	}
	
	@ExceptionHandler(ProgrammErrorException.class)
	public ResponseEntity<?> validProgrammErrorException(ProgrammErrorException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AoiRespone(e.getMessage()));
	}
}
