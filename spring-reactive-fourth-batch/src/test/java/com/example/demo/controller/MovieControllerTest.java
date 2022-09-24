package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.controller.rest.MovieRestController;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieDetailRepository;
import com.example.demo.repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = MovieRestController.class,
	excludeAutoConfiguration = {ReactiveSecurityAutoConfiguration.class})
//@Import(MovieRepository.class)
public class MovieControllerTest {

	@MockBean
	MovieRepository movieRepository;
	
	@MockBean
	MovieDetailRepository movieDetailRepository;
	
	@Autowired
	private WebTestClient client;
	
	@Test
	public void testGetAllMovie()
	{
		Movie movie1 = new Movie("1", "Movie 1",2010,"Movie 1 Director",null,null,null);
		Movie movie2 = new Movie("2", "Movie 2",2020,"Movie 2 Director",null,null,null);
		Mockito.when(this.movieRepository.findAll())
        .thenReturn(Flux.just(
        		movie1,
        		movie2
        		)
        		);
		
		Flux<Movie> movies= this.client.get() //
        .uri("http://localhost:8080/api/movies") //
        .accept(MediaType.APPLICATION_JSON)
        .exchange() //
		.expectStatus().isOk().expectHeader()
		.contentType(MediaType.APPLICATION_JSON) //
		.returnResult(Movie.class)
		.getResponseBody();
		
		/*
		.jsonPath("$.[0].id").isEqualTo("1")
		.jsonPath("$.[0].name").isEqualTo("Movie 1")
		.jsonPath("$.[0].year").isEqualTo(2010)
		.jsonPath("$.[0].director").isEqualTo("Movie 1 Director")
		.jsonPath("$.[1].id").isEqualTo("2")
		.jsonPath("$.[1].name").isEqualTo("Movie 2");
		*/
		StepVerifier //
        .create(movies) //
        .expectNext(movie1) //
        .expectNext(movie2) //
        .verifyComplete();
 
	}
}
