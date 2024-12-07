package com.cvr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BorrowDao {

	public boolean borrowBook(Borrowdetails borrowDetails) throws ClassNotFoundException {
        // SQL query to insert a new borrowing record into the database
        String sql = "INSERT INTO borrowings (userid,bookid, borrow_date) VALUES (?,?, NOW())";
        
        
        boolean rowDeleted = false;
        Class.forName("com.mysql.jdbc.Driver");
        
        
        try (Connection con = DBConnection.createConnection();
        		
        		PreparedStatement statement = con.prepareStatement(sql))
    	{
        	statement.setString(1, borrowDetails.getuid());
        	statement.setString(2, borrowDetails.getbid());
        	rowDeleted = statement.executeUpdate() > 0;
    	
    	}
        
        catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return rowDeleted;     
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
                

                
        

           

           
           
       