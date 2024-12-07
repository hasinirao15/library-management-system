<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>All Books</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      overflow: hidden;
      margin: 0;
      padding: 0;
    }

    .container {
      padding: 20px;
    }

    h1 {
      margin-bottom: 20px;
    }

    .card {
      margin-bottom: 20px;
    }
  </style>
</head>
<body>


<div class="container mt-5" id="allBooksSection">
    <h1>All Books</h1>
    <div id="booksList"></div>
     <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Author</th>
                <th>Copies</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.name}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.copies}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
  </div>
  
  
  
  
</body>
</html>












