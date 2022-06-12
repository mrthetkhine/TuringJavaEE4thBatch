package com.turing.javaee.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.ToString;

@Data
public class MovieDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Movie title should not be empty")
	private String title;

	@NotEmpty(message="Movie genre should not be empty")
	private String genre;
	
	private Integer year;
	
	private Date created_at = new Date();
	
	private Date updated_at = new Date();
}
