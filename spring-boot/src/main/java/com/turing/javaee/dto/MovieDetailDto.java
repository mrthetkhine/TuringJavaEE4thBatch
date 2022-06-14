package com.turing.javaee.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.turing.javaee.model.BaseEntity;

import lombok.Data;
import lombok.ToString;

@Data

public class MovieDetailDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String description;
		
}
