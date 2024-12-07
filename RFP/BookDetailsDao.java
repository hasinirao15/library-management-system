package com.cvr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDetailsDao {

	public  int bookadd(BookDetails bookDetails) throws ClassNotFoundException {
        String INSERT_BOOKS_SQL = "INSERT INTO books" +
            "  (id, name, author, copies) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DBConnection.createConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_BOOKS_SQL)) {
            preparedStatement.setString(1, bookDetails.getid());
            preparedStatement.setString(2, bookDetails.getname());
            preparedStatement.setString(3, bookDetails.getauthor());
            preparedStatement.setString(4, bookDetails.getcopies());
            

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
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