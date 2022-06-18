package com.turing.javaee.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turing.javaee.model.Address;
import com.turing.javaee.model.Gender;

import lombok.Data;

@Data
public class ActorDto {

	String firstName;
	String lastName;
	String fullName;
	Gender gender;
	
	Address address;
	
	@JsonIgnore
	private List<MovieDto> movies;
}
