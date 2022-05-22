package com.turing.javaee.dto;

import lombok.Data;

@Data
public class Message {
	String data;
	public Message(String data)
	{
		this.data = data;
	}
	
}
