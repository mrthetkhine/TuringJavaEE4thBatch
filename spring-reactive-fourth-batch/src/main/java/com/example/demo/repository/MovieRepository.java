package com.example.demo.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Movie;
import reactor.core.publisher.Flux;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
	Flux<Movie> findByDirector(String directorName);
	
	@Query("{ 'director': ?0}")
	Flux<Movie> findByDirectorCustomQuery(String director);
}
