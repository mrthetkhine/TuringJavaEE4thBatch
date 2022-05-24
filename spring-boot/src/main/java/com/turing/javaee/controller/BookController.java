package com.turing.javaee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String booksPost(@ModelAttribute Book book,Model model)
	{
		log.info("books post controller");
		log.info("Book title "+book.getTitle() + " Year "+book.getYear()+" Author "+book.getAuthor());
		model.addAttribute("book", book);
		return "books";
	}
}
