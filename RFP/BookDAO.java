package com.cvr;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/library";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Hasini1234*";
    private Connection jdbcConnection;

    public BookDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void connect() throws Exception {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws Exception {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	
    
	/*
	 * public int getBorrowingIdByUserId(int userId) throws Exception { String sql =
	 * "SELECT borrowing_id FROM borrowings WHERE userid = ?"; int borrowingId = -1;
	 * 
	 * connect();
	 * 
	 * PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	 * statement.setInt(1, userId);
	 * 
	 * ResultSet resultSet = statement.executeQuery();
	 * 
	 * if (resultSet.next()) { borrowingId = resultSet.getInt("borrowing_id"); }
	 * 
	 * resultSet.close(); statement.close(); disconnect();
	 * 
	 * return borrowingId; }
	 */
    
    public Date getBorrowDateByBorrowingId(int id) throws Exception {
        String sql = "SELECT borrow_date FROM borrowings WHERE bookid = ?";
        Date borrowDate = null;

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            borrowDate = resultSet.getDate("borrow_date");
        }

        resultSet.close();
        statement.close();
        disconnect();

        return borrowDate;
    }
    
    public boolean returnBook(int id) throws Exception {
        String sql = "DELETE FROM borrowings WHERE bookid = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
    
	  public List<Book> listAllBooks() throws Exception { List<Book> listBook = new
	  ArrayList<>(); String sql = "SELECT * FROM books";
	  
	  connect();
	  
	  PreparedStatement statement = jdbcConnection.prepareStatement(sql); ResultSet
	  resultSet = statement.executeQuery();
	  
	  while (resultSet.next()) { int id = resultSet.getInt("id"); String title =
	  resultSet.getString("title"); String author = resultSet.getString("author");
	  
	  Book book = new Book(id, title, author); listBook.add(book); }
	  
	  resultSet.close(); statement.close();
	  
	  disconnect();
	  
	  return listBook; }
	 
   
}
