package com.example.demo.controller;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.controller.rest.MovieRestController;
import com.example.demo.model.Movie;

import reactor.core.publisher.Flux;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class IntegrationTest {
	@Autowired
	private WebTestClient client;
	
	
	@Test
	public void testGetAllMovies()
	{
		Flux<Movie> result = this.client.get()
		.uri("/api/movies") //
        .accept(MediaType.APPLICATION_JSON)
        .exchange() //
		.expectStatus().isOk().expectHeader()
		.contentType(MediaType.APPLICATION_JSON) //
		//.expectBodyList(Movie.class)
		.returnResult(Movie.class)
		.getResponseBody();
		
		
		result.subscribe(movie->{
			System.out.println("Movie "+movie);
			assertNotNull(movie.getId(),"Movie Id should not be null");
			assertNotNull(movie.getName(),"Movie name should not be null");
			assertTrue(movie.getName().length()!=0, "Movie name should not be empty string");
			assertNotNull(movie.getDirector(),"Movie Id should not be null");
		});
	}
	@Test
	public void testGetMovieById()
	{
		//Just for tutorial purpose , don't do in real world
		String id="62dfe9d5067cce1f526bae38";
		Flux<Movie> result = this.client.get()
		.uri("/api/movies/"+id) //
        .accept(MediaType.APPLICATION_JSON)
        .exchange() //
		.expectStatus().isOk().expectHeader()
		.contentType(MediaType.APPLICATION_JSON) //
		//.expectBodyList(Movie.class)
		.returnResult(Movie.class)
		.getResponseBody();
		
		
		result.subscribe(movie->{
			System.out.println("Movie "+movie);
			assertEquals(movie.getId(),id);
			assertNotNull(movie.getName(),"Movie name should not be null");
			assertTrue(movie.getName().length()!=0, "Movie name should not be empty string");
			assertNotNull(movie.getDirector(),"Movie Id should not be null");
		});
	}
}
