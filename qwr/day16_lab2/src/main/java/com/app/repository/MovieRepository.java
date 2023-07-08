package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Movie;

public interface MovieRepository 
extends JpaRepository<Movie, Long> {
	// add a method for auth
	List<Movie> findByMovieNameContainingIgnoreCase(String movieName);

}
