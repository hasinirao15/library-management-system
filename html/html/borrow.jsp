<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Borrow Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #794a21;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: flex-start; /* Align content to the left */
            align-items: center; /* Center vertically */
            height: 100vh;
            position: relative; /* Required for absolute positioning */
        }

        .background-image {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            width: 50%; /* Half of the page width */
            background-image: url('image.jpg'); /* Replace 'background-image.jpg' with your image path */
            background-size: cover;
            z-index: -1; /* Ensure the background is behind the content */
        }

        .container {
            margin : 120px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            width: 100%;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color:black;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 10px;
        }

        input[type="text"] {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus {
            border-color: #007bff;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        #message {
            margin-top: 20px;
            text-align: center;
            color: #007bff;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="background-image"></div>
    <div class="container">
        <h1>Borrow Book</h1>
        <form id="borrowForm"  action="BorrowServlet" method="post" >
            <label for="userId">Enter User ID:</label>
            <input type="text" id="userId" name="userId">
            <label for="bookId">Enter Book ID:</label>
            <input type="text" id="bookId" name="bookId">
            <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		 : request.getAttribute("errMessage")%></span>
            <input type="submit" value="Borrow"></input>
        </form>
        <div id="message"></div>
    </div>

  <!--   <script>
        document.getElementById('borrowForm').addEventListener('submit', function(event) {
            event.preventDefault();
            
            var bookId = document.getElementById('bookId').value;

            fetch('BorrowBookServlet?bookId=' + encodeURIComponent(bookId))
                .then(response => response.text())
                .then(message => {
                    document.getElementById('message').textContent = message;
                })
                .catch(error => {
                    console.error('Error borrowing book:', error);
                    document.getElementById('message').textContent = 'An error occurred. Please try again later.';
                });
        });
    </script> -->
</body>
</html>
