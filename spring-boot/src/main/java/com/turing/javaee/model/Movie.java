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
	
}
