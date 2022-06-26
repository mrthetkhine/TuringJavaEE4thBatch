package com.turing.javaee.dao;
import java.util.List;

import com.turing.javaee.dto.GenreCount;
import com.turing.javaee.dto.GenreCountDto;
import com.turing.javaee.model.*;

public interface MovieSearchDao {
	List<Movie> findAllMovie();
	List<Movie> findAllMovieByYearAfter(Integer year);
	List<Movie> findMovieByActionOrHorror();
	List<Movie> findMovieByTitleYear(String title,Integer year);
	List<Movie> findMovieByTitle(String title);
	List<Movie> findMovieWhichContainActor(String actorName);
	List<GenreCount> getMovieGenreCount();
	List<GenreCount> getMovieGenreCountHavingMoreThan(Long count);
	public List<Movie> findAllMovieByYear(Integer year);
}
