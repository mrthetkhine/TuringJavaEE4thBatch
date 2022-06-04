package com.turing.javaee.service;

import java.util.List;

import com.turing.javaee.model.Book;

public interface BookService {
	List<Book> getAllBook();
	int saveNewBook(Book book);
}
