package com.turing.javaee.service;

import java.util.List;
import java.util.Optional;

import com.turing.javaee.dto.GenreCountDto;
import com.turing.javaee.dto.MovieDto;
import com.turing.javaee.model.Movie;

public interface MovieService {
	List<MovieDto> getAllMovie();
	Optional<MovieDto> getMovieById(Long movieId);
	MovieDto saveMovie(MovieDto movie);
	void deleteMovieById(Long movieId);
	List<GenreCountDto> getMovieGenreCount();
}
