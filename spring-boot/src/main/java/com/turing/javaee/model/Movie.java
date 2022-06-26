package com.turing.javaee.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import com.turing.javaee.controller.rest.MovieController;
import com.turing.javaee.model.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@FilterDef(
	    name = "yearFilter", 
	    parameters = @ParamDef(name = "year", type = "integer") 
	)	
@Filters( {
    @Filter(name="yearFilter", condition="year=:year"),
  
} )
@Slf4j
@Data
@ToString
@Entity
public class Movie extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String title;
	
	@Column
	private String genre;
	
	@Column
	private Integer year;
	
	@OneToOne(mappedBy="movie",
			cascade = CascadeType.ALL,
			fetch= FetchType.LAZY)
	MovieDetail movieDetail;
	
	@OneToMany(
			cascade= CascadeType.ALL,
			orphanRemoval = true
			)
	@JoinColumn(name="movie_id")
	List<Comment> comments;
	
	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	@JoinTable(name="actor_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	List<Actor> actors;
	
	/*
	@PostLoad
	private void postLoad()
	{
		log.info("PostLoad for movie entity "+this.getId());
	}
	
	@PreUpdate
    private void preUpdateFunction(){
        log.info("PreUpdate method called");
    }

    @PostUpdate
    private void postUpdateFunction(){
        log.info("PostUpdate method called");
    }
    */
    
}
