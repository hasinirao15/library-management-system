package com.cvr;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchBook")
public class SearchBookServlet extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private SearchInterfaceDao bookDAO;

    public void init() {
        bookDAO = new SearchDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        BookDetails searchedBook = bookDAO.getBookById(bookId);
		 List<BookDetails> books = bookDAO.getAllBooks(); 
		 if(searchedBook!=null)
        {
			 request.setAttribute("searchedBook", searchedBook);
        
		 request.setAttribute("listBook", books); 
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchbook.jsp");
        dispatcher.forward(request, response);
        }
		 else
		 {
			 String message="Book not Found";
			 request.setAttribute("listBook", books); 
			 request.setAttribute("errMessage", message); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
			 request.getRequestDispatcher("/searchbook.jsp").forward(request, response);
		 }
    }
}
