package com.turing.javaee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenreCount {
	String genre;
	Long count;
	
	
}
