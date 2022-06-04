package com.turing.javaee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turing.javaee.dao.BookDao;
import com.turing.javaee.model.Book;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/*
	static { 
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
	} 
	catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	Connection connection;
	BookDaoImpl()
	{
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_fourth_batch","root","root123!@#");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}  
	}
	Connection getConnection()
	{
		return this.connection;
	}
	
	@Override
	public List<Book> getAllBook() {
		List<Book> books = new ArrayList<>();
		try {
			PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Book");
			ResultSet result = st.executeQuery();
			while(result.next())
			{
				Long id = result.getLong("id");
				String title = result.getString("title");
				Long category = result.getLong("category");
				Long year = result.getLong("year");
				String author = result.getString("author");
				String email = result.getString("email");
				
				Book book = new Book(id,title,category,year+"",author,email);
				
				books.add(book);
			}
			result.close();
			st.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
*/
	@Override
	public List<Book> getAllBook() {
		return jdbcTemplate.query(
                "SELECT * from Book",
                (rs, rowNum) ->new Book(
                                rs.getLong("id"),
                                rs.getString("title"),
                                rs.getLong("category"),
                                rs.getLong("year")+"",
                                rs.getString("author"),
                                rs.getString("email")
                        )
        );
		
	}
	@Override
	public Book getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Book book) {
		return jdbcTemplate.update(
                "INSERT INTO Book(title,category,year,author,email) values(?,?,?,?,?)",
                book.getTitle(), book.getCategory(),book.getYear(),book.getAuthor(), book.getEmail());
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

}
