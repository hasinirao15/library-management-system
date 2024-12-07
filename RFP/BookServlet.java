package com.cvr;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/book")
public class BookServlet extends jakarta.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        try {
            switch (action) {
                case "return":
                    returnBook(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Book> listBook = bookDAO.listAllBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
        dispatcher.forward(request, response);
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Date borrowDate = bookDAO.getBorrowDateByBorrowingId(id);
        bookDAO.returnBook(id);
        LocalDate returnDate = LocalDate.now();
        long daysBorrowed = returnDate.toEpochDay() - borrowDate.toLocalDate().toEpochDay();
        double fine = calculateFine(daysBorrowed);
        request.setAttribute("fine", fine);
        request.getRequestDispatcher("fine.jsp").forward(request, response);
    }
    private double calculateFine(long daysBorrowed) {
        double fine = 0.0;
        long allowedDays = 1; // Assuming 2 weeks allowed borrowing period
        long overdueDays = daysBorrowed - allowedDays;

        if (overdueDays > 0) {
            fine = overdueDays * 1.0; // Assuming $1 fine per overdue day
        }

        return fine;
    }
}


