package com.turing.javaee.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.turing.javaee.model.BaseEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="movie_detail")
public class MovieDetail extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String description;
	
	@ToString.Exclude
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="movie_id")
	Movie movie;

}
