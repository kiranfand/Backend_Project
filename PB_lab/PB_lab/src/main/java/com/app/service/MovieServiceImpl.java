
package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entity.Movie;
import com.app.repository.MovieRepository;
@Service
@Transactional


public class MovieServiceImpl implements MovieService{
	
	@Autowired // by type : Field Level DI
	private MovieRepository movRepo;

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movRepo.findAll();
	}

	@Override
	public Movie addMovDetails(Movie transientMov) {
		// TODO Auto-generated method stub
		return movRepo.save(transientMov);
	}

	@Override
	public String deleteMovDetails(Long movieno) {
		String msg="movie deleted Sucessfully";
		if(movRepo.existsById(movieno)) {
			movRepo.deleteById(movieno);
		}
		return msg;
	}

	@Override
	public Movie getMovDetails(Long movieno) {
		// TODO Auto-generated method stub
		return movRepo.findById(movieno).orElseThrow(()-> new ResourceNotFoundException("Invalid Movieid"));
	}

	@Override
	public Movie updateMovDetails(Movie detachedMov) {
		// TODO Auto-generated method stub
		return movRepo.save(detachedMov);
	}

	

	
	}
	
	
	
	
	



