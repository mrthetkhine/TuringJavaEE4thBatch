package com.turing.javaee.service;

import java.util.List;
import java.util.Optional;

import com.turing.javaee.model.Book;

public interface BookService {
	List<Book> getAllBook();
	int saveNewBook(Book book);
	int updateBook(Book book);
	int deleteBookById(Long bookId );
	Optional<Book> getBookById(Long bookId);
}
