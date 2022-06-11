package com.turing.javaee.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String genre;
	
	@Column
	private Integer year;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;
}
