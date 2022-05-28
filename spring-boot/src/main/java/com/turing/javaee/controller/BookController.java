package com.turing.javaee.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee.model.Book;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/books")
@Slf4j
public class BookController {
	@GetMapping
	public String books(Model model)
	{
		log.info("books controller");
		Book book = new Book();
		book.setTitle("Java");
		model.addAttribute("book", book);
		return "books";
	}
	@PostMapping
	public String booksPost(@Valid @ModelAttribute Book book,BindingResult bindingResult,Model model)
	{
		log.info("books post controller");
		log.info("Book title "+book.getTitle() + " Year "+book.getYear()+" Author "+book.getAuthor());
		if(bindingResult.hasErrors())
		{
			log.info("books post controller have error "+ bindingResult.getErrorCount());
		}
		model.addAttribute("book", book);
		return "books";
	}
}
