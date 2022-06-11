package com.turing.javaee.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turing.javaee.model.Movie;

@Repository
public interface MovieDao extends CrudRepository<Movie, Long>{

}
