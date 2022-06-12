package com.turing.javaee.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.turing.javaee.controller.BookController;
import com.turing.javaee.dao.MovieDao;
import com.turing.javaee.dto.MovieDto;
import com.turing.javaee.model.Movie;
import com.turing.javaee.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movies")
@Tag(description = "Movie API", name = "Movie")
public class MovieController {
	
	
	@Autowired
	MovieService movieService;
	
	@Operation(summary = "Get all movie", 
            description = "Fetch the list of movie from database")
	 @ApiResponses(value = { 
	            @ApiResponse(responseCode = "200", 
	                    description = "When sucess it return the list of movie"),
	            @ApiResponse(responseCode = "400", 
	                    description = "Return bad request if parameter is invalid", 
	                    content = { @Content(examples = { @ExampleObject(value = "[]") }) }),
	            @ApiResponse(responseCode = "404", 
	                    description = "Return 404 if there is no resource", 
	                    content = { @Content(examples = { @ExampleObject(value = "") }) }) }) 
	@GetMapping
	List<Movie> getAllMovie()
	{
		log.info("get all movie rest api");
		return   this.movieService.getAllMovie();
	}
	@GetMapping("/{movieId}")
	ResponseEntity<Movie> getMovie(@PathVariable Long movieId)
	{
		log.info("get a movie rest api");
		Optional<Movie> movieResult = this.movieService.getMovieById(movieId);
		if(movieResult.isPresent())
		{
			return ResponseEntity.ok(movieResult.get());
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	ResponseEntity<MovieDto> saveMovie(@RequestBody @Valid MovieDto movieDto)
	{
		log.info("Movie " +movieDto);
		MovieDto newMovie = this.movieService.saveMovie(movieDto);
		return  ResponseEntity.status(201).body(newMovie);
	}
	@PutMapping("/{movieId}")
	ResponseEntity<MovieDto> updateMovie(@PathVariable Long movieId,@RequestBody @Valid MovieDto movieDto)
	{
		log.info("Movie " +movieDto);
		
		if( this.movieService.getMovieById(movieId).isPresent())
		{
			movieDto.setId(movieId);
			MovieDto newMovie = this.movieService.saveMovie(movieDto);
			return  ResponseEntity.ok(newMovie);
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{movieId}")
	ResponseEntity<Movie> deleteMovie(@PathVariable Long movieId)
	{
		log.info("delete a movie rest api");
		Optional<Movie> movieResult = this.movieService.getMovieById(movieId);
		if(movieResult.isPresent())
		{
			this.movieService.deleteMovieById(movieId);
			return ResponseEntity.ok(movieResult.get());
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
}
