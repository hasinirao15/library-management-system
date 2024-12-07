package com.cvr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class BorrowServlet extends jakarta.servlet.http.HttpServlet {

	private static final long serialVersionUID = -8879506651514686482L;
	private BorrowDao borrowdao;
	public void init() {
		borrowdao = new BorrowDao();
	}
	public BorrowServlet() // default constructor
	{
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookid = request.getParameter("bookId");
        String userid = request.getParameter("userId");
        Borrowdetails borrowDetails = new Borrowdetails();
       
		borrowDetails.setuid(userid);
        borrowDetails.setbid(bookid);
       
		try {
	    	
			 
			 boolean success = borrowdao.borrowBook(borrowDetails);
			 
		        if (success) {
		        	 request.getRequestDispatcher("/ListBooks").forward(request, response);
		        } 
		        else {
		        	 String message="Failed to Borrow Book";
		        	 request.setAttribute("errMessage", message); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
					 request.getRequestDispatcher("/borrow.jsp").forward(request, response);
		            
		        }
		       
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
    
       /* BorrowBookDAO dao = new BorrowBookDAO();
        boolean success = dao.borrowBook(bookId, userId);
       
        String message;
        if (success) {
            message = "Book borrowed successfully!";
        } else {
            message = "Failed to borrow book. Please try again.";
        }
       
        PrintWriter out = response.getWriter();
        out.println(message);*/
    }
