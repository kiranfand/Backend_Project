package com.app.exception_handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custome_exception.ResourseNotFoundException;
import com.app.dto.ApiResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		
		Map<String, String> map = new HashMap<String, String>();
		for(FieldError f : e.getFieldErrors())
			map.put(f.getField(), f.getDefaultMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<?> handleResourseNotFoundException(ResourseNotFoundException e){
		System.out.println("in handle res not found"+e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDto(e.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e){
		System.out.println("in catch all "+e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDto(e.getMessage()));
	}
}
