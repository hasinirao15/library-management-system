package com.cvr;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class DeleteBooks extends jakarta.servlet.http.HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8879506651514686482L;
	private DeleteBooksDao deleteBooksDao;
	public void init() {
		deleteBooksDao = new DeleteBooksDao();
	}
	
	public DeleteBooks() // default constructor
	{
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    try {
    	//BookDetails book = deleteBooksDao.getBookById(id);
		deleteBooksDao.deleteBook(id);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    request.getRequestDispatcher("/ListBooks").forward(request, response);
}
}