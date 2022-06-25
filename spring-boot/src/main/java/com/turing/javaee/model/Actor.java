package com.turing.javaee.model;

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

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Actor extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(name = "firstName")
	String firstName;

	@NotNull
	@Column(name = "lastName")
	String lastName;

	@Formula("concat(first_name,\" \",last_name)")
	String fullName;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	Gender gender;
	
	Address address;
	
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, 
				cascade = CascadeType.ALL, 
				mappedBy = "actors")
	private List<Movie> movies;
}
