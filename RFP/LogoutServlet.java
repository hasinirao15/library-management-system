package com.cvr;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
	 HttpSession session = request.getSession(false); //Fetch session object

		if(session!=null) //If session is not null
		 {
			 session.invalidate(); //removes all session attributes bound to the session
			 request.setAttribute("errMessage", "You have logged out successfully");
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
			 requestDispatcher.forward(request, response);
			 System.out.println("Logged out");
		 }
	}
}