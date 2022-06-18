package com.turing.javaee.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	public String street;

	public String township;

	public String city;

}