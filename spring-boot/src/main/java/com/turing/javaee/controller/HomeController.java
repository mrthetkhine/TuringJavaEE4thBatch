package com.turing.javaee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee.dto.Message;
import com.turing.javaee.service.MessageService;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	MessageService service;
	
	@GetMapping(produces = "application/json")
	public Message home()
	{
		System.out.println("Home controller");
		return service.getMessage();
	}
}
