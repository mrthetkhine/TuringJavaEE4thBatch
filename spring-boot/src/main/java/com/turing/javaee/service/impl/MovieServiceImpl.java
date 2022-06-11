package com.turing.javaee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee.dao.MovieDao;
import com.turing.javaee.model.Movie;
import com.turing.javaee.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	
	@Override
	public List<Movie> getAllMovie() {
		
		return (List<Movie>)movieDao.findAll();
	}

}
