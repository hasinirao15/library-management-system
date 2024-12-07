package com.cvr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListBooksDao {

	public  List<BookDetails> listAllBooks() throws ClassNotFoundException {
		 String sql = "SELECT * FROM books";

        int result = 0;
        List<BookDetails> listBook = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        try 
        {
        	Connection con = DBConnection.createConnection();
        	Statement statement = con.createStatement();
        	ResultSet resultSet = statement.executeQuery(sql);
        	while (resultSet.next()) {
				/*
				 * String id=resultSet.getString("id"); String name=resultSet.getString("name");
				 * String author=resultSet.getString("author"); String
				 * copies=resultSet.getString("copies");
				 */
        		BookDetails book=new BookDetails();
        		book.setid(resultSet.getString("id"));
        		book.setname(resultSet.getString("name"));
        		book.setauthor(resultSet.getString("author"));
        		book.setcopies(resultSet.getString("copies"));
        		listBook.add(book);
        	}
        	
        }catch (SQLException e) {
        	printSQLException(e);
        }
		/*
		 * Statement statement = jdbcConnection.createStatement();         ResultSet
		 * resultSet = statement.executeQuery(sql);                   while
		 * (resultSet.next()) {             int id = resultSet.getInt("book_id");
		 *             String title = resultSet.getString("title");             String
		 * author = resultSet.getString("author");             float price =
		 * resultSet.getFloat("price");                           Book book = new
		 * Book(id, title, author, price);             listBook.add(book);         }
		 *                   resultSet.close();         statement.close();
		 */

		/*
		 * try (Connection con = DBConnection.createConnection();
		 * 
		 * // Step 2:Create a statement using connection object PreparedStatement
		 * preparedStatement = con.prepareStatement(sql)) {
		 * preparedStatement.setString(1, bookDetails.getid());
		 * preparedStatement.setString(2, bookDetails.getname());
		 * preparedStatement.setString(3, bookDetails.getauthor());
		 * preparedStatement.setString(4, bookDetails.getcopies());
		 * 
		 * 
		 * System.out.println(preparedStatement); // Step 3: Execute the query or update
		 * query result = preparedStatement.executeUpdate();
		 * 
		 * } catch (SQLException e) { // process sql exception printSQLException(e); }
		 */
        return listBook;
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