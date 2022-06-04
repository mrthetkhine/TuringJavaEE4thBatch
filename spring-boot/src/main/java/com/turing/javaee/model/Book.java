package com.turing.javaee.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;



import com.turing.javaee.validation.BookYearValidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@BookYearValidation(message="Year must be equal or greater than 2000 for technology")
public class Book {

	Long id;
	
	@NotEmpty(message="{book.title.notempty}")
    @Size(min=3,max=100,message="{book.title.length}")
	String title;

	@NotNull(message="Category should not be empty")
	Long category;
	
	@NotNull(message="Year should not be empty")
	@Min(value=1800)
	@Pattern(regexp="^[0-9]+$",message="Year should be number")
	String year;
	
	@NotEmpty(message="Author should not be empty")
	String author;
	
	@NotEmpty(message="Author email should not be empty")
	@Email(message="Should be in valid email format")
	String email;
}
