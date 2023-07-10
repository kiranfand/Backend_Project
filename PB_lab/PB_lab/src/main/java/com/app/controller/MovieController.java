package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.entity.Movie;
import com.app.service.MovieServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
private MovieServiceImpl movieService;
	@GetMapping
	public List<Movie> getAllMovie(){
		return movieService.getAllMovies();
	}
//	@PostMapping
//	public Movie addMovie( @RequestBody Movie m) {
//		return movieService.addMovDetails(m);
//	}
	
	@PostMapping
	 public ResponseEntity<Movie>  saveMovieDetails(@org.springframework.web.bind.annotation.RequestBody Movie m){
		 System.out.println("In add emp details controller....");
		 return new ResponseEntity<>(movieService.addMovDetails(m),HttpStatus.CREATED);
	 }

	@DeleteMapping
	public String deleteMovie(@PathVariable Long movieNo) {
		String msg="deleted";
		movieService.deleteMovDetails(movieNo);
		return msg;
	}
	@GetMapping("/{movieno}")
	public Movie getMovieByid(@PathVariable Long movieno) {
		return movieService.getMovDetails(movieno);
		
	}
	@PutMapping("/{movieNo}")
	public Movie updateMovie(@org.springframework.web.bind.annotation.RequestBody Movie m) {
		return   movieService.updateMovDetails(m);
		
	}
}
