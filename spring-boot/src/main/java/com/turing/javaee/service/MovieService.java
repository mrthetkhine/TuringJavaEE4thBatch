package com.turing.javaee.service;

import java.util.List;
import java.util.Optional;

import com.turing.javaee.dto.GenreCount;
import com.turing.javaee.dto.GenreCountDto;
import com.turing.javaee.dto.MovieDto;
import com.turing.javaee.model.Movie;

public interface MovieService {
	List<MovieDto> getAllMovie();
	Optional<MovieDto> getMovieById(Long movieId);
	MovieDto saveMovie(MovieDto movie);
	void deleteMovieById(Long movieId);
	List<GenreCountDto> getMovieGenreCount();
	List<GenreCount> getMovieGenreCountByCriteria();
	
	List<MovieDto> findMovieByActionOrHorror();
	List<MovieDto> findMovieByPage(int pageNo,int size);
	List<MovieDto> findMovieOrderByYear();
	List<MovieDto> findTop5MovieOrderByYear();
	
	List<MovieDto> findByGenre(String genre);
	List<MovieDto> findByTitle(String title);
	List<MovieDto> searchByTitleAndGenre(String title,String genre);
	List<MovieDto> searchByTitleOrGenre(String title,String genre);
	
	List<MovieDto> searchByYearAfter(Integer year);
	List<MovieDto> searchByYear(Integer year);
	List<MovieDto> searchMovieWithActor(String actorName);
	List<MovieDto> searchMovieByTitleYear(String title,Integer year);
}
