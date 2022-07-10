package com.turing.javaee.service.specification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.turing.javaee.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovieSpecification {
	public static Specification<Movie> getAllMovieByYear(Integer year) {
		log.info("getAll Movie By year Spec ");
		return new Specification<Movie>() {
			
			@Override
			public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate director = criteriaBuilder.equal(root.get("year"), year);
				return director;
			}

		};
	}
	
	public static Specification<Movie> getMovieByTitleYear(String title,Integer year) {
		log.info("getMovieByYearTitle Spec ");
		return new Specification<Movie>() {
			
			@Override
			public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				ArrayList<Predicate> predicates = new ArrayList<Predicate>();
				if(title != null)
				{
					predicates.add(criteriaBuilder.equal(root.get("title"), title));
				}
				if(year != null)
				{
					predicates.add(criteriaBuilder.equal(root.get("year"), year));
				}
				Predicate and = criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
				query.where(and);
				return and;
			}

		};
	}
}
