package com.turing.javaee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee.dto.Message;
import com.turing.javaee.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/view")
@Slf4j
public class HelloController {
	
	@Autowired
	MessageService service;
	
	@GetMapping("/hello")
	public String hello(Model model)
	{
		log.info("view controller");
		model.addAttribute("message", service.getMessage());
		//String str = null;
		//str.toUpperCase();
		return "hello";
	}
	@PostMapping("/hello")
	public String helloPost(Model model)
	{
		log.info("view post controller");
		model.addAttribute("message", new Message("Data from post method"));
		//String str = null;
		//str.toUpperCase();
		return "hello";
	}
	@GetMapping("/another")
	public String another(Model model) throws Exception
	{
		log.info("view controller");
		model.addAttribute("message", service.getMessage());
		//throw new Exception("Exception in another method");
		return "hello";
	}
}
