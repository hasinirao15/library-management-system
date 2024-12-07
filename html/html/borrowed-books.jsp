<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Books</title>
<link rel="stylesheet" type="text/css" href="bookstyle.css">
</head>
<body>
<h1 class="title">My Books</h1>
<div id="books">
	<c:forEach var="book" items="${listBook}">
    <div class="book"  onclick="redirectToLogin()"  data-title="Book Title 1" data-author="Author 1" data-alphabet="A">
        <img src="book2.jpg" alt="Book 1">
        <div class="book-info">
            <h2 class="book-title">Book Title: <c:out value="${book.name}"/></h2>
            <p class="book-id">Book ID: <c:out value="${book.id}"/> </p>
            <p class="book-author">Author name: <c:out value="${book.author}"/> </p>
           
              
              <td>
                        <a href="book?action=return&id=${book.id}" onclick="return confirm('Are you sure you want to return this book?');">Return</a>
                    </td>
             
        </div>
    </div>
    </c:forEach>