package com.turing.javaee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.javaee.model.Book;
import com.turing.javaee.model.Category;
import com.turing.javaee.service.BookService;
import com.turing.javaee.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/books")
@Slf4j
public class BookController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public String getAllBook(Model model)
	{
		log.info("get allbooks controller");
		List<Book> books = this.bookService.getAllBook();
		model.addAttribute("books", books);
		
		return "all_books";
	}
	@GetMapping("/{bookId}")
	public String getBook(@PathVariable Long bookId,Model model)
	{
		log.info("get A Book controller");
		Optional<Book> book = this.bookService.getBookById(bookId);
		
		if(book.isPresent())
		{
			model.addAttribute("book", book.get());
		}
		else
		{
			model.addAttribute("book", new Book());
		}
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories", categories);
		
		return "books";
	}
	@GetMapping("/new")
	public String books(Model model)
	{
		log.info("books controller");
		
		Book book = new Book();
		book.setTitle("Java");
		model.addAttribute("book", book);
		
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("categories", categories);
		
		return "books";
	}
	@PostMapping
	public String booksPost(@Valid @ModelAttribute Book book,
							BindingResult bindingResult,
							Model model)
	{
		log.info("books post controller");
		log.info("Book title "+book.getTitle() + " Year "+book.getYear()+" Author "+book.getAuthor());
		if(!bindingResult.hasErrors())
		{
			log.info("Save book "+ book);
			if(book.getId() == null)
			{
				this.bookService.saveNewBook(book);
				return "redirect:/books/new";
			}
			else
			{
				this.bookService.updateBook(book);
				return "redirect:/books";
			}
		
		}
		else
		{
			log.info("Book have error "+ bindingResult.getErrorCount());
			
			List<Category> categories = categoryService.getAllCategory();
			model.addAttribute("categories", categories);
			model.addAttribute("book", book);
		}
		
		return "books";
	}
	@GetMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable Long bookId,Model model)
	{
		log.info("Delete  Book controller");
		this.bookService.deleteBookById(bookId);
		return "redirect:/books";
	}
}
