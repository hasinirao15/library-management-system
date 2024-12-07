package com.cvr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteBooksDao {
public boolean deleteBook(String id) throws ClassNotFoundException {
    String sql = "DELETE FROM books where id = ?";
   
    boolean rowDeleted = false;
    Class.forName("com.mysql.jdbc.Driver");
    
    
    try (Connection con = DBConnection.createConnection();
    		
    		PreparedStatement statement = con.prepareStatement(sql))
	{
		statement.setString(1, id);
		rowDeleted = statement.executeUpdate() > 0;
	}
    
    catch (SQLException e) {
        // process sql exception
        printSQLException(e);
    }
	return rowDeleted;   
}

public BookDetails getBookById(String id) throws ClassNotFoundException {
    String sql = "select * FROM books where id = ?";
   
    boolean rowDeleted = false;
    Class.forName("com.mysql.jdbc.Driver");
    BookDetails book=null;
    
    try (Connection con = DBConnection.createConnection();
    		
    		PreparedStatement statement = con.prepareStatement(sql))
	{
		statement.setString(1, id);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet != null) {
			book = (BookDetails) resultSet.getObject(1);
		}
	}
    
    catch (SQLException e) {
        // process sql exception
        printSQLException(e);
    }
	return book;   
}

private  void printSQLException(SQLException ex) {
    for (Throwable e: ex) {
        if (e instanceof SQLException) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
}
}