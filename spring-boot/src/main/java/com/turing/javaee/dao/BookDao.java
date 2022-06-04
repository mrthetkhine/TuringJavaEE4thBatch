package com.turing.javaee.dao;
import java.util.List;

import com.turing.javaee.model.*;

public interface BookDao {
	List<Book> getAllBook();
	Book getById(Long id);
	int insert(Book book);
	void update(Book book);
}
