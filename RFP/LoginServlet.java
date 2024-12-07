package com.cvr;

import java.io.IOException;

import com.cvr.LoginBean;
import com.cvr.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends jakarta.servlet.http.HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() // default constructor
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
		System.out.println("#############doPost############");

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String role=request.getParameter("usertype");

		LoginBean loginBean = new LoginBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.

		loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
		 loginBean.setPassword(password);
		 loginBean.setRole(role);

		LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.

		String userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function

		if(userValidate.equals("STUDENT")) //If function returns success string then user will be rooted to Home page
		 {
			 
			 //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
			 
		                HttpSession session = request.getSession();
		                session.setAttribute("username", userName);
			 request.getRequestDispatcher("/main.html").forward(request, response);
			 
		 }
		else if(userValidate.equals("ADMIN"))
		{
			HttpSession session = request.getSession();
            session.setAttribute("username", userName); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
			 request.getRequestDispatcher("addBooks.html").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
		}
		 else
		 {
			 request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
			 request.getRequestDispatcher("/Login.jsp").forward(request, response);//forwarding the request
		 }
    }
}