package com.turing.javaee.service;

import java.util.List;
import java.util.Optional;

import com.turing.javaee.dto.MovieDto;
import com.turing.javaee.model.Movie;

public interface MovieService {
	List<Movie> getAllMovie();
	Optional<Movie> getMovieById(Long movieId);
	MovieDto saveMovie(MovieDto movie);
	void deleteMovieById(Long movieId);
}
