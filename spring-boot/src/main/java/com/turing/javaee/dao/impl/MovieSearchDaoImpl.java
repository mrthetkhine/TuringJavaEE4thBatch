package com.turing.javaee.dao.impl;

import com.turing.javaee.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.turing.javaee.dao.MovieSearchDao;

@Repository
public class MovieSearchDaoImpl extends AbstractJpaDAO<Movie> implements MovieSearchDao{

	@Override
	public List<Movie> findAllMovie() {
		return super.findAll();
	}

	@Override
	public List<Movie> findAllMovieByYearAfter(Integer year) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(Movie.class);
		Root<Movie> movie = criteriaQuery.from(Movie.class);
		criteriaQuery.where(cb.gt(movie.get("year"), cb.parameter(Integer.class,"year")));
		
		Query query =  (Query) this.entityManager.createQuery(criteriaQuery);
		query.setParameter("year", year);
		
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
		In<String> inClause = cb.in(movie.get("genre"));
		for (String genre : genreList) {
		    inClause.value(genre);
		}
		criteriaQuery = criteriaQuery.select(movie).where(inClause).orderBy(cb.desc(movie.get("year")));
		Query query =  (Query) this.entityManager.createQuery(criteriaQuery);
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
			Predicate yearCondition = cb.equal(movie.get("year"), year);
			predicates.add(yearCondition);
		}
		if(predicates.size() >0)
		{
		
			Predicate and = cb.and(predicates.toArray(new Predicate[] {}));
			criteriaQuery.where(and);
		}	
		
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}
}
