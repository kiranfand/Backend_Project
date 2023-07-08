package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
// add a method for auth
	Optional<Movie> findByEmailAndPassword(String em, String pass);
}
