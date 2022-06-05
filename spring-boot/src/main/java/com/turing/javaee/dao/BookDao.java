package com.turing.javaee.dao;
import java.util.List;
import java.util.Optional;

import com.turing.javaee.model.*;

public interface BookDao {
	List<Book> getAllBook();
	Optional<Book> getById(Long id);
	int insert(Book book);
	int update(Book book);
	int delete(Long id);
}
