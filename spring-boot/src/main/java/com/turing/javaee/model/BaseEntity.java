package com.turing.javaee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@CreationTimestamp
	private Date created_at ;
	
	@UpdateTimestamp
	private Date updated_at;
}
