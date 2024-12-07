package com.cvr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDetailsDao {

	public int registerUser(UserDetails userDetails) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (rollno, firstname, lastname, username, password, email, usertype) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DBConnection.createConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, userDetails.getRollno());
            preparedStatement.setString(2, userDetails.getFirstName());
            preparedStatement.setString(3, userDetails.getLastName());
            preparedStatement.setString(4, userDetails.getUsername());
            preparedStatement.setString(5, userDetails.getPassword());
            preparedStatement.setString(6, userDetails.getEmail());
            preparedStatement.setString(7, userDetails.getUserType());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
	
	private void printSQLException(SQLException ex) {
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
