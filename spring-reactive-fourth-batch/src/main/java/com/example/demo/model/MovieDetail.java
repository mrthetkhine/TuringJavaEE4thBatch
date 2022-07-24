package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("movie_detail")
public class MovieDetail {
	
	
	@Id
    private String id;
	 
    @NotBlank
    @Size(max = 140)
    private String details;
}
