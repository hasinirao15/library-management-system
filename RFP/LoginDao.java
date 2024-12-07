package com.cvr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.cvr.LoginBean;
import com.cvr.DBConnection;

public class LoginDao {
	 public String authenticateUser(LoginBean loginBean)
	 {
		 String userName = loginBean.getUserName(); //Assign user entered values to temporary variables.
		 String password = loginBean.getPassword();
		 String role = loginBean.getRole();
		 
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;

		 String userNameDB = "";
		 String passwordDB = "";
		 String roleDB="";

		 try
		 {
			 con = DBConnection.createConnection(); //Fetch database connection object
			 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
			 resultSet = statement.executeQuery("select username,password,usertype from user"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.

			 while(resultSet.next()) // Until next row is present otherwise it return false
			 {
			  userNameDB = resultSet.getString("username"); //fetch the values present in database
			  passwordDB = resultSet.getString("password");
			  roleDB=resultSet.getString("usertype");

			   if(userName.equals(userNameDB) && password.equals(passwordDB) && role.equals(roleDB) )
			   {
				   if(roleDB.equals("student"))
					   return "STUDENT";
				   else
					   return "ADMIN";
				   ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
			   }
			 }
			 
		 } catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 return "Invalid user credentials"; // Return appropriate message in case of failure
	 }
	 
	 
	 
	 
	 public static String getUserId(String username) throws Exception {
	       
	       
			 
			
			 String sql = "SELECT rollno FROM user WHERE username = ?";
			 
	        String userId = "";
	       
			
	        
	        try (Connection con = DBConnection.createConnection();
	        		
	        		PreparedStatement statement = con.prepareStatement(sql))
	        {
	        	
	        	statement.setString(1, username);
	        ResultSet resultSet = statement.executeQuery();
	        
	        
	        if(resultSet.next()) {
	            userId = resultSet.getString("rollno");
	        }

			 }
	        catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}

	        return userId;
	    
	 }
	 
	 
	 
	 
	 
	 
}