package com.turing.javaee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee.service.MessageService;

@Controller
@RequestMapping("/view")
public class HelloController {
	
	@Autowired
	MessageService service;
	
	@GetMapping("/hello")
	public String view(Model model)
	{
		System.out.println("view controller");
		model.addAttribute("message", service.getMessage());
		return "hello";
	}
}
