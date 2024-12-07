<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fine Calculation</title>
    <link rel="stylesheet" href="fines.css">
</head>
<body>
    <div class="container">
        <h1>Fine Calculation</h1>
        <p class="fine-amount">Your fine is: &#8377;<%= request.getAttribute("fine") %></p>
        <div class="btn-container">
            <button class="btn" onclick="payFine()">Pay Fine</button>
        </div>
    </div>
    <div class="home-btn-container">
        <a class="btn home-btn" href="home.html">Return to Home Page</a>
    </div>

    <script>
        function payFine() {
            alert('Proceeding to payment...');
            // Add payment logic here
        }
    </script>
</body>
</html>
