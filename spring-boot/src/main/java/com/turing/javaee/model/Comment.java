package com.turing.javaee.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
public class Comment extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String comment;

	@ToString.Exclude
	@ManyToOne(
			cascade= CascadeType.ALL
			)
	@JoinColumn(name="movie_id")
	Movie movie;

}
