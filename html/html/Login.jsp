<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Student Login</title>
  <link rel="stylesheet" type="text/css" href="style_home.css">
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

<header style="height: 130px;">
  
<div class="logo">
	<img src="bimg111.jpg">
      <h1 style="color: white;font-size: 30px;">STUD</h1>
    </div>

      <nav>
        <ul>
          <li><a href="home.html">HOME</a></li>
          <li><a href="books?action=total">BOOKS</a></li>
          <li><a href="Login.jsp">LOGIN</a></li>
          <li><a href="signup.html">SIGNUP</a></li>
        </ul>
      </nav>
</header>


<section>

  <div class="log_img">
    <br> <br><br>
<div class="tab-container">
        <div class="tab active" onclick="toggleForm('student')">Student</div> 
        <div class="tab" onclick="toggleForm('admin')">admin</div>
    </div>
    
        
      <div class="login-forms">
       		<form class="login-form active" action="LoginServlet" method="post" onsubmit="return validate()">
            <h2 style="padding-bottom: 15px;font-size: 25px;text-align: center;">Student Login</h2>
            <label for="studentUsername" style="font-size: 20px;color: white;">Username:</label>
            <input type="text" id="studentUsername" name="username" required>
            <br>
            <label for="studentPassword" style="font-size: 20px;color: white;">Password:</label>
            <input type="password" id="studentPassword" name="password" required>
            <input type="hidden" name="usertype" value="<%= "student" %>">
			<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		 : request.getAttribute("errMessage")%></span>
            <input type="submit" value="Login"></input>
            <p>Don't have an account? <a href="signup.html">Sign up</a> here.</p>
        </form> 

        <form class="login-form" action="LoginServlet" method="post" onsubmit="return validate()">
            <h2 style="padding-bottom: 15px;font-size: 25px;text-align: center;">Admin Login</h2>
            <label for="adminUsername" style="font-size: 20px;color: white;">Username:</label>
            <input type="text" id="adminUsername" name="username" required>
            <br>
            <label for="adminPassword" style="font-size: 20px;color: white;">Password:</label>
            <input type="password" id="adminPassword" name="password" required>
            <input type="hidden" name="usertype" value="<%= "admin" %>">
			<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
		 : request.getAttribute("errMessage")%></span>
            <input type="submit" value="Login"></input>
            <p>Don't have an account? <a href="signup.html">Sign up</a> here.</p>
        </form>
    </div>

</section>

<script>
        	function toggleForm(type) {
            const studentTab = document.querySelector('.tab:nth-child(1)');
            const adminTab = document.querySelector('.tab:nth-child(2)');
            const studentForm = document.querySelector('.login-form:nth-child(1)');
            const adminForm = document.querySelector('.login-form:nth-child(2)');

            if (type === 'student') {
                studentTab.classList.add('active');
                adminTab.classList.remove('active');
                studentForm.classList.add('active');
                adminForm.classList.remove('active');
            } else if (type === 'admin') {
                studentTab.classList.remove('active');
                adminTab.classList.add('active');
                studentForm.classList.remove('active');
                adminForm.classList.add('active');
            }
        } 
        function validate()
        { 
        	 var username = document.form.username.value; 
        	 var password = document.form.password.value;

        	 if (username==null || username=="")
        	 { 
        	 alert("Username cannot be blank"); 
        	 return false; 
        	 }
        	 else if(password==null || password=="")
        	 { 
        	 alert("Password cannot be blank"); 
        	 return false; 
        	 } 
        }
    </script> 
    </div>
    <footer>
			<p style="color:white;  text-align: center; ">
				<br><br>
				Email: Online.library@gmail.com <br>
				Mobile: +88018********
			</p>
		</footer>
</body>
</html>