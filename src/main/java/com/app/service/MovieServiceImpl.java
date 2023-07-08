package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AuthRequestDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Movie;
import com.app.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
	// dep : movie repo i.f
	@Autowired // by type : Field Level DI
	private MovieRepository movieRepo;
	// dep : model mapper bean : for auto conversion entity --> dto
	@Autowired // by type : field level DI
	private ModelMapper mapper;

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();
	}

	@Override
	public Movie addmovieDetails(Movie transientmovie) {
		// TODO Auto-generated method stub
		return movieRepo.save(transientmovie);
	}

	@Override
	public String deletemovieDetails(Long movieId) {
		String mesg = "movie id invalid , can't delete movie details ";
		if (movieRepo.existsById(movieId)) {
			movieRepo.deleteById(movieId);
			mesg = "movie with ID=" + movieId + "  deleted !";
		}
		return mesg;
	}

	@Override
	public Movie getmovieDetails(Long movieId) {
		// TODO Auto-generated method stub
		return movieRepo.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid movie ID , Can't get movie details!!!!"));
	}

	
	public Movie updatemovieDetails(Movie detachedmovie) {
		// H.W : check if movie exists by id
		return movieRepo.save(detachedmovie);
	}

	@Override
	public AuthRespDTO authenticatemovie(AuthRequestDTO request) {
		// get email n pwd from request dto n invoke movie repo method : inherited API |
		// finder | custom query methods
		Movie movie = movieRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("movie not found : Invalid Email or password"));
		// movie : persistent Entity ---> DTO
		AuthRespDTO authRespDTO = mapper.map(movie, AuthRespDTO.class);
		return authRespDTO;
		/*
		 * 1. ModelMapper : create instance of DTO --calls MATCHING setters
		 *  --populates  DTO from src entity n rets it to the controller
		 */
	}

}
