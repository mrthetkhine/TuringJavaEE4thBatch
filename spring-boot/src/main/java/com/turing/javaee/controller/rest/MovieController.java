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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee.controller.BookController;
import com.turing.javaee.dao.MovieDao;
import com.turing.javaee.dto.GenreCountDto;
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
	List<MovieDto> getAllMovie()
	{
		log.info("get all movie rest api");
		return   this.movieService.getAllMovie();
	}
	@GetMapping("/paging")
	List<MovieDto> getAllMovieByPage(@RequestParam Integer pageNo, @RequestParam Integer size)
	{
		log.info("get all movie rest api");
		return   this.movieService.findMovieByPage(pageNo,size);
	}
	@GetMapping("/{movieId}")
	ResponseEntity<MovieDto> getMovie(@PathVariable Long movieId)
	{
		log.info("get a movie rest api");
		Optional<MovieDto> movieResult = this.movieService.getMovieById(movieId);
		if(movieResult.isPresent())
		{
			return ResponseEntity.ok(movieResult.get());
		}
		else
		{
			return  ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/genre-count")
	ResponseEntity<Object> getGenreCount()
	{
		log.info("get getGenreCount");
		List<GenreCountDto> genreCount = this.movieService.getMovieGenreCount();
		return ResponseEntity.ok(genreCount);
	}
	@GetMapping("/searchActionOrHorrorMovie")
	ResponseEntity<List<MovieDto>> searchActionOrHorrorMovie()
	{
		log.info("search searchActionOrHorrorMovie");
		List<MovieDto> movies = this.movieService.findMovieByActionOrHorror();
		return ResponseEntity.ok(movies);
	}
	@GetMapping("/searchByGenre")
	ResponseEntity<List<MovieDto>> searchByGenre(@RequestParam String genre)
	{
		log.info("search By Genere");
		List<MovieDto> movies = this.movieService.findByGenre(genre);
		return ResponseEntity.ok(movies);
	}
	@GetMapping("/searchByTitle")
	ResponseEntity<List<MovieDto>> searchTitle(@RequestParam String title)
	{
		log.info("search By searchTitle");
		List<MovieDto> movies = this.movieService.findByTitle(title);
		return ResponseEntity.ok(movies);
	}
	@GetMapping("/searchByTitleAndGenre")
	ResponseEntity<List<MovieDto>> searchByTitleAndGenre(@RequestParam String title,@RequestParam String genre)
	{
		log.info("search By @RequestParam String genre");
		List<MovieDto> movies = this.movieService.searchByTitleAndGenre(title, genre);
		return ResponseEntity.ok(movies);
	}
	@GetMapping("/searchByTitleOrGenre")
	ResponseEntity<List<MovieDto>> searchByTitleOrGenre(@RequestParam String title,@RequestParam String genre)
	{
		log.info("search By searchByTitleOrGenre");
		List<MovieDto> movies = this.movieService.searchByTitleOrGenre(title, genre);
		return ResponseEntity.ok(movies);
	}
	@GetMapping("/searchByYearAfter")
	ResponseEntity<List<MovieDto>> searchByYearAfter(@RequestParam Integer year)
	{
		log.info("search By searchByYearAfter");
		List<MovieDto> movies = this.movieService.searchByYearAfter(year);
		return ResponseEntity.ok(movies);
	}
	@GetMapping("/orderByYear")
	ResponseEntity<List<MovieDto>> orderByYear()
	{
		log.info("search By orderByYear");
		List<MovieDto> movies = this.movieService.findMovieOrderByYear();
		return ResponseEntity.ok(movies);
	}
	@GetMapping("/top5OrderByYear")
	ResponseEntity<List<MovieDto>> top5OrderByYear()
	{
		log.info("search By top5OrderByYear");
		List<MovieDto> movies = this.movieService.findTop5MovieOrderByYear();
		return ResponseEntity.ok(movies);
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
	ResponseEntity<MovieDto> deleteMovie(@PathVariable Long movieId)
	{
		log.info("delete a movie rest api");
		Optional<MovieDto> movieResult = this.movieService.getMovieById(movieId);
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
