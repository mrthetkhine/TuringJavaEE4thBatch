package com.turing.javaee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turing.javaee.dao.UserJpaRepository;
import com.turing.javaee.dto.Message;
import com.turing.javaee.model.User;
import com.turing.javaee.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	//@Autowired
	//MessageService service;
	

	
	@Autowired
	UserJpaRepository userRepository;
	
	@GetMapping("/")
	public String home()
	{
		log.info("Home Controller");
		//List<Movie> movies = this.movieRepository.findAll();
		//log.info("Movies "+ movies.get(0));
		//log.info("Size of movie "+movies.size());
		
		//Optional<Movie> movie = this.movieRepository.findById(1L);
		//log.info("Movie 1"+movie);
		//log.info("Shopping cart size at "+cart.getMovies().size());
		return "home";
	}
	@GetMapping("/login")
	String login(Model model,@RequestParam(value = "error",required = false) Boolean error){
		System.out.println("Login get");
		model.addAttribute("error", error);
		return "login";
	}
	@PostMapping("/login")
	String loginPost(Model model){
		System.out.println("Login post");

		
		return "login";
	}
	/*
	@GetMapping("/userAccountInfo")
	String page(Model model){
		
		log.info("controller userAccountInfo");
		
		return "userAccountInfo";
	}*/
	
	@GetMapping("/userAccountInfo")
	String page(Model model){
		
		log.info("controller userAccountInfo");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    
		    System.out.println("Loggined UserName "+currentUserName);
		    User user = this.userRepository.findByName(currentUserName);
		    model.addAttribute("user", user);
		}
		return "userAccountInfo";
	}
	
	@GetMapping("/admin")
	String admin(Model model){
		
		log.info("Admin route");
		return "admin";
	}
	@GetMapping("/logoutSuccessful")
	String logoutSuccess(Model model)
	{
		System.out.println("You have been logout");
		return "logoutSuccessful";
	}
	@GetMapping("/test")
	String test(Model model)
	{
		log.info("Test controller");
		return "logoutSuccessful";
	}
	
}
