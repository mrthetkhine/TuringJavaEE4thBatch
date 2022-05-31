package com.turing.javaee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee.model.Book;
import com.turing.javaee.model.Category;
import com.turing.javaee.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/template")
@Slf4j
public class ThymeleafController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/collection")
	public String books(Model model)
	{
		log.info("ThymeleafController controller");
	
		
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories", categories);
		
		return "collection-demo";
	}
	
}
