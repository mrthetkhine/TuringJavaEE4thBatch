package com.turing.javaee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.turing.javaee.dto.GenreCountDto;
import com.turing.javaee.model.Movie;

@Repository
public interface MovieDao extends PagingAndSortingRepository<Movie, Long>,JpaSpecificationExecutor<Movie>,QueryByExampleExecutor<Movie>{
	
	//JPQL->HQL
	@Query("SElECT m from Movie m")
	Iterable<Movie> getAllMovie();
	
	@Query("SElECT m from Movie m WHERE m.title=:title")
	Iterable<Movie> getAllMovieByTitle(@Param(value = "title") String title);
	
	//SQL
	@Query(value="SElECT * FROM Movie",nativeQuery=true)
	Iterable<Movie> getAllMovieViaNativeSQL();
	
	//SQL
	@Query(value="SELECT genre,COUNT(*) as count FROM movie GROUP BY genre",
			nativeQuery=true)
	List<GenreCountDto> getMovieGenreCount();
	
	@Query(value="SElECT m FROM Movie m WHERE m.genre IN ('Horror','Action')")
	List<Movie> findMovieForActionOrHorror();
	
	@Query(value="SElECT m FROM Movie m JOIN m.actors act WHERE act.fullName=:actorName")
	List<Movie> findMovieWhichContainActor(@Param(value = "actorName") String actorName);
	//search
	List<Movie> findByGenre(String genre);
	List<Movie> findByTitleLike(String title);
	List<Movie> findAllByOrderByYearDesc();
	List<Movie> findTop5ByOrderByYear();
	
	List<Movie> findByTitleAndGenre(String title,String genre);
	List<Movie> findByTitleOrGenre(String title,String genre);
	
	List<Movie> findByYearGreaterThan(Integer year);
}
