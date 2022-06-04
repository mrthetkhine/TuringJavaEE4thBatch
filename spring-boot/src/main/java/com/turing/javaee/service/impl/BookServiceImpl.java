package com.turing.javaee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.javaee.dao.BookDao;
import com.turing.javaee.model.Book;
import com.turing.javaee.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> getAllBook() {
		
		return bookDao.getAllBook();
	}

	@Override
	public int saveNewBook(Book book) {
		
		return bookDao.insert(book);
	}

}
