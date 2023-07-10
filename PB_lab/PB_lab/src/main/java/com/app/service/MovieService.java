package com.app.service;

import java.util.List;

import com.app.entity.Movie;

public interface MovieService {
	
	List<Movie> getAllMovies();

	Movie addMovDetails(Movie transientMov);

	String deleteMovDetails(Long movieno);

	Movie getMovDetails(Long movieno);

	
	Movie updateMovDetails(Movie detachedMov);

	


}
