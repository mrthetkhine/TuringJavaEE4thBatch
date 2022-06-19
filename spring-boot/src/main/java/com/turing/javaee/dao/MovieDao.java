package com.turing.javaee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turing.javaee.dto.GenreCountDto;
import com.turing.javaee.model.Movie;

@Repository
public interface MovieDao extends CrudRepository<Movie, Long>{
	
	//JPQL->HQL
	@Query("SElECT m from Movie m")
	Iterable<Movie> getAllMovie();
	
	//SQL
	@Query(value="SElECT * FROM Movie",nativeQuery=true)
	Iterable<Movie> getAllMovieViaNativeSQL();
	
	//SQL
	@Query(value="SELECT genre,COUNT(*) as count FROM movie GROUP BY genre",
			nativeQuery=true)
	List<GenreCountDto> getMovieGenreCount();
}
