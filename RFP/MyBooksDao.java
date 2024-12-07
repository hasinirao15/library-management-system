package com.cvr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyBooksDao {
    // Existing code ...

    public List<BookDetails> listBorrowedBooks(String userId) throws Exception {
        List<BookDetails> listBook = new ArrayList<>();
        String sql = "SELECT b.id, b.name, b.author FROM books b INNER JOIN borrowings bb ON b.id = bb.bookid WHERE bb.userid = ?";
        int result=0;
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection con = DBConnection.createConnection();
        		
        		PreparedStatement statement = con.prepareStatement(sql))
        {
        	
        	statement.setString(1, userId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
        
        	BookDetails book = new BookDetails();
        	
        	book.setid (resultSet.getString("id"));
        	book.setname (resultSet.getString("name"));
        	book.setauthor (resultSet.getString("author"));
        
           
            listBook.add(book);
        }
        }

        catch (SQLException e) {
        	printSQLException(e);
        }
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
