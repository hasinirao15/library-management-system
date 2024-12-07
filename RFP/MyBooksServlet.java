package com.cvr;


import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/books")
public class MyBooksServlet extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDAO;
    private MyBooksDao mybookDAO;
    private BookDAO bookDAO;
    private ListBooksDao listBooksDao;
    public void init() {
    	loginDAO = new LoginDao();
    	mybookDAO = new MyBooksDao();
    	bookDAO = new BookDAO();
    	listBooksDao = new ListBooksDao();
    }

    public MyBooksServlet() // default constructor
	{
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        try {
            switch (action) {
                case "listBorrowedBooks":
                    listBorrowedBooks(request, response);
                    break;
                case "show":
                    showBooksPage(request, response);
                    break;
                case "total":
                	totalBooksPage(request, response);
                case "search":
                	searchBooksPage(request, response);	
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    private void totalBooksPage(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
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
    private void searchBooksPage(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	List<BookDetails> listBook;
		try {
			listBook = listBooksDao.listAllBooks();
			request.setAttribute("listBook", listBook);
			
			  RequestDispatcher dispatcher = request.getRequestDispatcher("searchbook.jsp");
			 
	       
			 dispatcher.forward(request, response); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    private void showBooksPage(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	HttpSession session = request.getSession();
    	String username = (String) session.getAttribute("username");
    	
		try {
			String userId = LoginDao.getUserId(username);
			
	        session.setAttribute("userId", userId);
	        response.sendRedirect("books?action=listBorrowedBooks");
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    private void listBorrowedBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	try {
    		 
        	HttpSession session = request.getSession();
            String userId = (String) session.getAttribute("userId");
            List<BookDetails> listBook = mybookDAO.listBorrowedBooks(userId);
            request.setAttribute("listBook", listBook);
            RequestDispatcher dispatcher = request.getRequestDispatcher("borrowed-books.jsp");
            dispatcher.forward(request, response);
            
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }





    

    
       
    }


