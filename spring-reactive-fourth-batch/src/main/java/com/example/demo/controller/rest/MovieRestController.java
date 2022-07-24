package com.example.demo.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.example.demo.model.Movie;
import com.example.demo.model.MovieDetail;
import com.example.demo.repository.MovieDetailRepository;
import com.example.demo.repository.MovieRepository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/movies")
public class MovieRestController {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieDetailRepository movieDetailRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
	@GetMapping("/{id}")
    public Mono<ResponseEntity<Movie>> getMovieById(@PathVariable(value = "id") String movieId) {
        return movieRepository.findById(movieId)
                .map(savedMovie -> ResponseEntity.ok(savedMovie))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	@CrossOrigin
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Movie> streamMovie() {
        return movieRepository.findAll();
    }
	@GetMapping("/name")
    public Flux<Movie> getMovieByName(@RequestParam String movieName) {
		System.out.println("Movie name "+movieName);
		
		Movie movie = new Movie();
		movie.setName(movieName);
		
		//ExampleMatcher matcher = ExampleMatcher.matchingAny();
		Example<Movie> example = Example.of(movie);
        
		return movieRepository.findAll(example);
    }
	/*
	@GetMapping("/director")
    public List<Movie> searchByDirector(@RequestParam String director) {
		
		System.out.println("Director"+director);
		
		Query query = new Query(Criteria.where("director").is(director));
        
		List<Movie> movies = this.mongoTemplate.find(query, Movie.class);
		
		return movies;
    }*/
	@GetMapping("/director")
    public Flux<Movie> getMovieByDirector(@RequestParam String director) {
		System.out.println("Movie director "+director);
		//return movieRepository.findByDirector(director);
		return movieRepository.findByDirectorCustomQuery(director);
    }
	@PostMapping
    public Mono<Movie> createMovie(@Valid @RequestBody Movie movie) {
		
		if(movie.getDetails()!=null)
		{
			
			return this.movieDetailRepository.save(movie.getDetails())
				   .flatMap((movieDetails)->{
					   movie.setDetails(movieDetails);
					   return this.movieRepository.save(movie);
				   });
			
		}
		else
		{
			 return movieRepository.save(movie);
		}
       
    }
	@PutMapping("/{id}")
    public Mono<ResponseEntity<Movie>> updateMovie(@PathVariable(value = "id") String movieId,
                                                   @Valid @RequestBody Movie movie) {
        return movieRepository.findById(movieId)
                .flatMap(existingMovie -> {
                    existingMovie.setName(movie.getName());
                    existingMovie.setDirector(movie.getDirector());
                    existingMovie.setYear(movie.getYear());
                    return movieRepository.save(existingMovie);
                })
                .map(updatedMovie -> new ResponseEntity<>(updatedMovie, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	@DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteMovie(@PathVariable(value = "id") String movieId) {

        return movieRepository.findById(movieId)
                .flatMap(existingMovie ->
                			movieRepository.delete(existingMovie)
                            			   .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
