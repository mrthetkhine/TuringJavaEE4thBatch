package com.turing.javaee.dao;
import java.util.List;
import com.turing.javaee.model.*;

public interface MovieSearchDao {
	List<Movie> findAllMovie();
	List<Movie> findAllMovieByYearAfter(Integer year);
	List<Movie> findMovieByActionOrHorror();
	List<Movie> findMovieByTitleYear(String title,Integer year);
}
