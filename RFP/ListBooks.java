package com.cvr;
import java.io.IOException;
import java.sql.Connection;

import java.sql.Statement;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class ListBooks extends jakarta.servlet.http.HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8879506651514686482L;
	private ListBooksDao listBooksDao;
	public void init() {
		listBooksDao = new ListBooksDao();
	}
	
	public ListBooks() // default constructor
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookDetails> listBook;
		try {
			listBook = listBooksDao.listAllBooks();
			request.setAttribute("listBook", listBook);
			
			  RequestDispatcher dispatcher = request.getRequestDispatcher("ListBooks.jsp");
			 
	       
			 dispatcher.forward(request, response); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
		
		
	
}
