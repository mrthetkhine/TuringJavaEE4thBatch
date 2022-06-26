package com.turing.javaee.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turing.javaee.controller.rest.MovieController;
import com.turing.javaee.dao.MovieDao;
import com.turing.javaee.dao.MovieSearchDao;
import com.turing.javaee.dto.GenreCount;
import com.turing.javaee.dto.GenreCountDto;
import com.turing.javaee.dto.MovieDto;
import com.turing.javaee.model.Movie;
import com.turing.javaee.model.MovieDetail;
import com.turing.javaee.service.MovieService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	
	@Autowired
	MovieSearchDao movieSearchDao;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<MovieDto> getAllMovie() {
		
		//Iterable<Movie> movies = movieDao.findAll();
		//Iterable<Movie> movies = movieDao.getAllMovie();
		//Iterable<Movie> movies = movieDao.getAllMovieViaNativeSQL();
		Iterable<Movie> movies = movieSearchDao.findAllMovie();
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> findMovieByPage(int pageNo, int size) {
		
		Page<Movie> movies = movieDao.findAll(PageRequest.of(pageNo, size));
		return entitiesToDtoList(movies);
	}
	List<MovieDto> entitiesToDtoList(Iterable<Movie> movies)
	{
		List<MovieDto> movieDtos = new ArrayList<>();
		for(Movie movie: movies)
		{
			MovieDto dto = mapper.map(movie, MovieDto.class);
			movieDtos.add(dto);
		}
		return movieDtos;
	}
	@Override
	public Optional<MovieDto> getMovieById(Long movieId) {
		Optional<Movie> movieResult = movieDao.findById(movieId);
		if(movieResult.isPresent())
		{
			MovieDto dto = mapper.map(movieResult.get(), MovieDto.class);
			return Optional.of(dto);
		}
		else
		{
			return Optional.empty();
		}
	}

	@Transactional(rollbackFor = { SQLException.class })
	@Override
	public MovieDto saveMovie(MovieDto movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		MovieDetail movieDetail = mapper.map(movieDto.getMovieDetail(), MovieDetail.class);
		
		movie.setMovieDetail(movieDetail);
		movieDetail.setMovie(movie);
		
		Movie savedMovie = movieDao.save(movie);
		
		log.info("Saved movie "+savedMovie );
		
		MovieDto savedMovieDto = mapper.map(savedMovie, MovieDto.class);
		return savedMovieDto;
	}

	@Override
	public void deleteMovieById(Long movieId) {
		movieDao.deleteById(movieId);
	}
	@Override
	public List<GenreCountDto> getMovieGenreCount() {
		List<GenreCountDto> genreCounts = this.movieDao.getMovieGenreCount();
		
		log.info("Genres Counts " + genreCounts.size());
		return genreCounts;
	}
	@Override
	public List<GenreCount> getMovieGenreCountByCriteria()
	{
		//List<GenreCount> genreCounts = this.movieSearchDao.getMovieGenreCount();
		List<GenreCount> genreCounts = this.movieSearchDao.getMovieGenreCountHavingMoreThan(1L);
		log.info("Genres Counts " + genreCounts.size());
		return genreCounts;
	}
	@Override
	public List<MovieDto> findMovieOrderByYear()
	{
		Iterable<Movie> movies = movieDao.findAllByOrderByYearDesc();
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> findTop5MovieOrderByYear() {
		Iterable<Movie> movies = movieDao.findTop5ByOrderByYear();
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> findByGenre(String genre) {
		Iterable<Movie> movies = movieDao.findByGenre(genre);
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> findByTitle(String title)
	{
		//Iterable<Movie> movies = movieDao.getAllMovieByTitle(title);
		Iterable<Movie> movies = movieSearchDao.findMovieByTitle(title);
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> searchByTitleAndGenre(String title,String genre)
	{
		Iterable<Movie> movies = movieDao.findByTitleAndGenre(title, genre);
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> searchByTitleOrGenre(String title,String genre)
	{
		Iterable<Movie> movies = movieDao.findByTitleOrGenre(title, genre);
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> findMovieByActionOrHorror()
	{
		//Iterable<Movie> movies = movieDao.findMovieForActionOrHorror();
		Iterable<Movie> movies = movieSearchDao.findMovieByActionOrHorror();
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> searchByYearAfter(Integer year)
	{
		//Iterable<Movie> movies = movieDao.findByYearGreaterThan(year);
		Iterable<Movie> movies = movieSearchDao.findAllMovieByYearAfter(year);
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> searchByYear(Integer year) {
		
		Iterable<Movie> movies = movieSearchDao.findAllMovieByYear(year);
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> searchMovieWithActor(String actorName)
	{
		//Iterable<Movie> movies = movieDao.findMovieWhichContainActor(actorName);
		Iterable<Movie> movies = movieSearchDao.findMovieWhichContainActor(actorName);
		return entitiesToDtoList(movies);
	}
	@Override
	public List<MovieDto> searchMovieByTitleYear(String title,Integer year)
	{
		Iterable<Movie> movies = movieSearchDao.findMovieByTitleYear(title, year);
		return entitiesToDtoList(movies);
	}
	
}
