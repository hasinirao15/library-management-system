




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Catalog</title>
<link rel="stylesheet" type="text/css" href="bookstyle.css">
</head>
<body>
<h1 class="title">Book Catalog</h1>


<div class="container">
    <div class="alphabet" onclick="filterBooks('A')">A</div>
    <div class="alphabet" onclick="filterBooks('B')">B</div>
    <div class="alphabet" onclick="filterBooks('C')">C</div>
    <div class="alphabet" onclick="filterBooks('D')">D</div>
    <div class="alphabet" onclick="filterBooks('E')">E</div>
    <div class="alphabet" onclick="filterBooks('F')">F</div>
    <div class="alphabet" onclick="filterBooks('G')">G</div>
    <div class="alphabet" onclick="filterBooks('H')">H</div>
    <div class="alphabet" onclick="filterBooks('I')">I</div>
    <div class="alphabet" onclick="filterBooks('J')">J</div>
    <div class="alphabet" onclick="filterBooks('K')">K</div>
    <div class="alphabet" onclick="filterBooks('L')">L</div>
    <div class="alphabet" onclick="filterBooks('M')">M</div>
    <div class="alphabet" onclick="filterBooks('N')">N</div>
    <div class="alphabet" onclick="filterBooks('O')">O</div>
    <div class="alphabet" onclick="filterBooks('P')">P</div>
    <div class="alphabet" onclick="filterBooks('Q')">Q</div>
    <div class="alphabet" onclick="filterBooks('R')">R</div>
    <div class="alphabet" onclick="filterBooks('S')">S</div>
    <div class="alphabet" onclick="filterBooks('T')">T</div>
    <div class="alphabet" onclick="filterBooks('U')">U</div>
    <div class="alphabet" onclick="filterBooks('V')">V</div>
    <div class="alphabet" onclick="filterBooks('W')">W</div>
    <div class="alphabet" onclick="filterBooks('X')">X</div>
    <div class="alphabet" onclick="filterBooks('Y')">Y</div>
    <div class="alphabet" onclick="filterBooks('Z')">Z</div>
</div>

<div id="books">
	<c:forEach var="book" items="${listBook}">
    <div class="book"  onclick="redirectToLogin()"  data-title="Book Title 1" data-author="Author 1" data-alphabet="A">
        <img src="book2.jpg" alt="Book 1">
        <div class="book-info">
            <h2 class="book-title">Book Title: <c:out value="${book.name}"/></h2>
            <p class="book-id">Book ID: <c:out value="${book.id}"/> </p>
            <p class="book-author">Author name: <c:out value="${book.author}"/> </p>
            <p class="book-copies">Copies: <c:out value="${book.copies}"/></p>
              
             
             
        </div>
    </div>
    </c:forEach>




    <!-- Add more books as needed -->
     
</div>

<script>
    function redirectToLogin() {
        var loggedIn = checkLoggedIn(); // Check if user is logged in
        if (!loggedIn) {
            // If not logged in, redirect to the login page
            window.location.href = 'student_login.html';
        }
    }

    function checkLoggedIn() {
        // Example: Check if user is logged in by checking a session or token
        // Replace this with your actual authentication logic
        // For now, returning false for demonstration purposes
        return false;
    }

    function filterBooks(alphabet) {
        var books = document.querySelectorAll('.book');
        books.forEach(function(book) {
            if (book.dataset.alphabet === alphabet) {
                book.classList.add('active');
            } else {
                book.classList.remove('active');
            }
        });
    }
    
</script>
    
</body>
</html>
