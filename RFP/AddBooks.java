package com.cvr;
import java.io.IOException;
import java.sql.Connection;

import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class AddBooks extends jakarta.servlet.http.HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8879506651514686482L;
	private BookDetailsDao bookDetailsDao;
	public void init() {
	    	bookDetailsDao = new BookDetailsDao();
	}
	
	public AddBooks() // default constructor
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		String name = request.getParameter("bookName");
		String author = request.getParameter("author");
		String copies = request.getParameter("copies");
		
		
		
		BookDetails bookDetails = new BookDetails();
		bookDetails.setid(id);
		bookDetails.setname(name);
		bookDetails.setauthor(author);
		bookDetails.setcopies(copies);
		
        
		 try {
	        	
				bookDetailsDao.bookadd(bookDetails);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		 request.getRequestDispatcher("/ListBooks").forward(request, response);
			/* response.sendRedirect("ListBooks.jsp"); */
		}
	
}
