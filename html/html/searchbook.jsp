
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
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .title {
        text-align: center;
        margin-top: 20px;
    }
  
  .search-container
   {
            text-align: center;
            margin-top: 10px; /* Adjusted margin */
            margin-bottom: 20px;
    }
   #searchInput
   {
            width: 60%; /* Adjusted width */
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            margin-right: 10px;
    }

    .search-container button
    {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border: 1px solid #c99c83;
            border-radius: 5px;
            background-color: #c99c83;
            color: #fff;
            transition: background-color 0.3s ease;
     }

     .search-container button:hover 
     {
           background-color: #0056b3;
     }
</style>

</head>
<body>
<h1 class="title">Book Catalog</h1>

<div class="search-container">
    <form action="searchBook" method="get">
        <input type="text" name="bookId" id="searchInput" placeholder="Search by book ID" required>
        <button type="submit" id="searchButton" class="search-button">Search</button>
    </form>
</div>

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
    <c:if test="${not empty searchedBook}">
        <div class="book" data-alphabet="${searchedBook.name.charAt(0)}">
            <img src="book2.jpg" alt="Book 1">
            <div class="book-info">
                <h2 class="book-title">Book Title: <c:out value="${searchedBook.name}"/></h2>
                <p class="book-id">Book ID: <c:out value="${searchedBook.id}"/> </p>
                <p class="book-author">Author name: <c:out value="${searchedBook.author}"/> </p>
                <p class="book-copies">Copies: <c:out value="${searchedBook.copies}"/></p>
            </div>
        </div>
    </c:if>
 
 <div class="error">
 <c:if test="${not empty errMessage}">
 <h2><c:out value="${errMessage}"/></h2>
 </c:if>
  </div>
<div id="books">
    <c:forEach var="book" items="${listBook}">
        <div class="book" data-alphabet="${book.name.charAt(0)}">
            <img src="book2.jpg" alt="Book 1">
            <div class="book-info">
                <h2 class="book-title">Book Title: <c:out value="${book.name}"/></h2>
                <p class="book-id">Book ID: <c:out value="${book.id}"/> </p>
                <p class="book-author">Author name: <c:out value="${book.author}"/> </p>
                <p class="book-copies">Copies: <c:out value="${book.copies}"/></p>
                
            </div>
        </div>
    </c:forEach>
</div>

<script>
    function filterBooks(alphabet) {
        var books = document.querySelectorAll('.book');
        books.forEach(function(book) {
            if (book.dataset.alphabet.toUpperCase() === alphabet) {
                book.style.display = 'block';
            } else {
                book.style.display = 'none';
            }
        });
    }
</script>
</body>
</html>


