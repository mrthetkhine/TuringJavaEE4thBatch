package com.turing.javaee.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee.controller.BookController;
import com.turing.javaee.dao.MovieDao;
import com.turing.javaee.model.Movie;
import com.turing.javaee.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	List<Movie> getAllMovie()
	{
		log.info("get all movie rest api");
		return   this.movieService.getAllMovie();
	}
}
