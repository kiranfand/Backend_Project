package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequestDTO;
import com.app.entities.Movie;
import com.app.service.MovieService;

@RestController // =@Controller + @ResponseBody
@RequestMapping("/Movies")
@CrossOrigin(origins = "http://localhost:3000")
//To Tell SC to add CORS resp header : cross origin resourse sharing  , 
//so that web browser security model allows accessing the resp.
public class MovieController {
	// dep : service layer i/f
	@Autowired
	private MovieService movieService;

	public MovieController() {
		System.out.println("in def ctor of " + getClass());
	}

	// http://localhost:8080/Movies/ , method = GET
	// add a req handling method to ret list of movies
	@GetMapping
	public List<Movie> listmovies() {
		System.out.println("in list movies");
		return movieService.getAllMovies();
	}

	// http://localhost:8080/Movies/ , method = POST
	// add a req handling method to save an movie
	@PostMapping
	public ResponseEntity<?> savemovieDetails(@RequestBody Movie transientmovie) {
		System.out.println("in save " + transientmovie);// not null , id : null
		return new ResponseEntity<>(movieService.addmovieDetails(transientmovie), HttpStatus.CREATED);
	}

	// http://localhost:8080/Movies/10 , method = DELETE
	@DeleteMapping("/{movieId}")
	public ApiResponse deletemovieDetails(@PathVariable Long movieId) {
		System.out.println("in del movie dtls " + movieId);
		// invoke service layer method , get it's resp , wrap it in a DTO -->
		// marshalling --> json --sent to fron end
		return new ApiResponse(movieService.deletemovieDetails(movieId));
	}

	// http://localhost:8080/Movies/10 , method = GET
	@GetMapping("/{movieId}")
	public Movie getmovieDetails(@PathVariable Long movieId) {
		System.out.println("in get movie dtls " + movieId);
		return movieService.getmovieDetails(movieId);
	}

	// http://localhost:8080/Movies , method = PUT
	@PutMapping
	public Movie updatemovieDetails(@RequestBody Movie detachedmovie) {

		System.out.println("in update movie " + detachedmovie);// id : not null
		return movieService.updatemovieDetails(detachedmovie);
	}

	// http://host:port/Movies/signin , Method : POST
	@PostMapping("/signin")
	public ResponseEntity<?> authenticatemovie(@RequestBody @Valid AuthRequestDTO request) {
		System.out.println("in auth movie " + request);
//		try {
		return ResponseEntity.status(HttpStatus.OK)
				.body(movieService.authenticatemovie(request));
//		} catch (RuntimeException e) {
//			System.out.println(e);
//			return ResponseEntity.
//					status(HttpStatus.NOT_FOUND).
//					body(new ApiResponse(e.getMessage()));
//		}
	}

}
