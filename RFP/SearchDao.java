package com.cvr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDao implements SearchInterfaceDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/library";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Hasini1234*";

    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public BookDetails getBookById(String bookId) {
    	BookDetails book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setString(1, bookId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String copies = rs.getString("copies");
                book = new BookDetails(id, name, author, copies);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return book;
       
        	
    }
	
	  @Override public List<BookDetails> getAllBooks() 
	  { 
		  List<BookDetails> books = new ArrayList<>(); 
	  try (Connection connection = getConnection();
	  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) 
	  { 
		  ResultSet rs = preparedStatement.executeQuery(); 
		  while (rs.next()) 
		  { 
			  String id = rs.getString("id"); 
			  String name = rs.getString("name"); 
			  String author = rs.getString("author"); 
			  String copies = rs.getString("copies"); 
			  books.add(new BookDetails(id, name, author, copies)); 
			  } 
		  } 
	  catch (SQLException e) {
	  e.printStackTrace(); 
	  } 
	  return books; 
	  }
	 
}
