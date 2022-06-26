package com.turing.javaee.dao.impl;

import com.turing.javaee.model.Movie;
import com.turing.javaee.service.impl.MovieServiceImpl;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.turing.javaee.dao.MovieSearchDao;
import com.turing.javaee.dto.GenreCount;

@Slf4j
@Repository
public class MovieSearchDaoImpl extends AbstractJpaDAO<Movie> implements MovieSearchDao{

	private static final String YEAR = "year";
	private static final String GENRE = "genre";
	@Override
	public List<Movie> findAllMovie() {
		return super.findAll();
	}

	@Override
	public List<Movie> findAllMovieByYearAfter(Integer year) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		criteriaQuery.where(cb.gt(movie.get(YEAR), cb.parameter(Integer.class,YEAR)));
		
		Query<Movie> query =  (Query<Movie>) this.entityManager.createQuery(criteriaQuery);
		query.setParameter(YEAR, year);
		
		return query.getResultList();
	}
	@Override
	public List<Movie> findMovieByActionOrHorror() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		/*
		criteriaQuery.where(cb.or(
								cb.equal(movie.get("genre"), "Horror"), 
								cb.equal(movie.get("genre"), "Action")
								)
							);
		*/
		List<String> genreList =  Arrays.asList("Horror","Action");
		In<String> inClause = cb.in(movie.get(GENRE));
		for (String genre : genreList) {
		    inClause.value(genre);
		}
		criteriaQuery = criteriaQuery.select(movie)
									.where(inClause)
									.orderBy(cb.desc(movie.get(YEAR)));
		
		Query<Movie> query =  (Query<Movie>) this.entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	@Override
	public List<Movie> findMovieByTitleYear(String title,Integer year)
	{
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();
		if(title != null)
		{
			Predicate nameCondition = cb.equal(movie.get("title"), title);
			predicates.add(nameCondition);
		}
			
		if( year != null)
		{
			Predicate yearCondition = cb.equal(movie.get(YEAR), year);
			predicates.add(yearCondition);
		}
		if(predicates.size() >0)
		{
		
			Predicate and = cb.and(predicates.toArray(new Predicate[] {}));
			criteriaQuery.where(and);
		}	
		
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Movie> findMovieByTitle(String title) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		Predicate like = cb.like(
				movie.get("title"), 
				"%"+title+"%"
				);
		criteriaQuery = criteriaQuery.select(movie)
					 .where( like );
		
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}
	@Override
	public List<Movie> findMovieWhichContainActor(String actorName) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		
		Join actor = movie.join("actors");
		Predicate predicate = cb.equal(actor.get("fullName"), actorName);
		
		criteriaQuery = criteriaQuery.select(movie)
									 .where(
											 predicate
											);
		
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}
	@Override
	public List<GenreCount> getMovieGenreCount()
	{
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<GenreCount> criteriaQuery = cb.createQuery(GenreCount.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		
		CompoundSelection<GenreCount> projection = cb.construct(GenreCount.class, movie.get(GENRE),cb.count(movie.get(GENRE)));
		
		criteriaQuery.select(projection)
					 .groupBy(movie.get(GENRE));
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}
	@Override
	public List<GenreCount> getMovieGenreCountHavingMoreThan(Long count)
	{
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<GenreCount> criteriaQuery = cb.createQuery(GenreCount.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		Expression<Long> genreCount = cb.count(movie.<Number>get(GENRE));
		CompoundSelection<GenreCount> projection = cb.construct(GenreCount.class, movie.get(GENRE),cb.count(movie.get(GENRE)));
		
		criteriaQuery.select(projection)
					 .groupBy(movie.get(GENRE))
					 .having(cb.greaterThan(genreCount, count));
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}
	@Override
	@Transactional
	public List<Movie> findAllMovieByYear(Integer year) {
		log.info("search By searchByYear "+year);
		Session session = this.entityManager.unwrap(Session.class);
		session.enableFilter("yearFilter");
		//  .setParameter("year", year);
		Query query = session.createQuery("from Movie");
		
		return query.list();
	}
}
