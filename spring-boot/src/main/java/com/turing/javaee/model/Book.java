package com.turing.javaee.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class Book {

	@NotEmpty(message="Title should not be empty")
    @Size(min=3,max=100,message="Title should be within 3 to 100 in length")
	String title;
	
	@Min(value=1800)
	Integer year;
	
	@NotEmpty(message="Author should not be empty")
	String author;
	
	@NotEmpty(message="Author email should not be empty")
	@Email(message="Should be in valid email format")
	String email;
}
