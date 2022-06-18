package com.turing.javaee.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.ToString;

@Data
public class MovieDto extends BaseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@NotEmpty(message="Movie title should not be empty")
	private String title;

	@NotEmpty(message="Movie genre should not be empty")
	private String genre;
	
	private Integer year;
	
	private MovieDetailDto movieDetail;
	
	private List<CommentDto> comments;
	private List<ActorDto> actors;
}
