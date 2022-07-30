package com.example.demo.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

//@Jacksonized 
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "users")
public class User {

  @Id
  private String id;

  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  private String username;

 
  private String email;

  @Size(min = 4, message = "Minimum password length: 8 characters")
  private String password;

 
  private List<Role> roles;


	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

	  
}
