package com.cvr;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Registration extends jakarta.servlet.http.HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8879506651514686482L;
	private UserDetailsDao userDetailsDao;
	public void init() {
	    	userDetailsDao = new UserDetailsDao();
	}
	
	public Registration() // default constructor
	{
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rollno = request.getParameter("rollno");
        String email = request.getParameter("email");
        String userType = request.getParameter("userType");
        
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(firstName);
        userDetails.setLastName(lastName);
        userDetails.setUsername(username);
        userDetails.setPassword(password);
        userDetails.setRollno(rollno);
        userDetails.setEmail(email);
        userDetails.setUserType(userType);
        
        try {
        	userDetailsDao.registerUser(userDetails);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("Login.jsp");
	}

		
}
