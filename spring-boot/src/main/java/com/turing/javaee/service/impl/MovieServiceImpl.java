package com.turing.javaee.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee.controller.rest.MovieController;
import com.turing.javaee.dao.MovieDao;
import com.turing.javaee.dto.MovieDto;
import com.turing.javaee.model.Movie;
import com.turing.javaee.service.MovieService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<Movie> getAllMovie() {
		
		return (List<Movie>)movieDao.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(Long movieId) {
		return movieDao.findById(movieId);
	}

	@Override
	public MovieDto saveMovie(MovieDto movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		Movie savedMovie = movieDao.save(movie);
		
		log.info("Saved movie "+savedMovie );
		
		MovieDto savedMovieDto = mapper.map(savedMovie, MovieDto.class);
		return savedMovieDto;
	}

	@Override
	public void deleteMovieById(Long movieId) {
		movieDao.deleteById(movieId);
	}

}
