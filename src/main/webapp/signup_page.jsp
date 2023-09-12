<%@page import="com.learning.devops.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="./css/style.css">
<jsp:include page="links.jsp" />
</head>
<body>
	<div class="container">
		<div class="box">
			<div class="content-box">
				<div class="logo-box">
					<span class="devops">Devops</span>
					<div class="learing-box">
						<span class="learing">Learning</span>
					</div>
				</div>
				<form action="signup" method="POST" class="login-form-box">
					<div class="form-title">
						<span>Sign Up</span>
					</div>
					
					<%
					Message message = (Message) session.getAttribute("message");
					if(message != null){
						%>
						<div class="<%= message.getCssClass() %>"><span><%= message.getContent()%></span></div>
						<% 
						session.removeAttribute("message");
					}
					%>
					<label for="username"><b>Name</b></label> <input type="text" class="input-field"
						placeholder="Enter name" name="username"> <label for="useremail"><b>Email</b></label>
					<input type="text" class="input-field" placeholder="Enter emial" name="useremail">
					<label for="userpassword"><b>Password</b></label> <input
						type="password" class="input-field" placeholder="Enter password" name="userpassword">
					<label for="ucpassword"><b>Confirm Password</b></label> <input
						type="password" class="input-field" placeholder="Enter password" name="ucpassword">

					<div class="submit-btn-box">
						<input type="submit" placeholder="Sign Up">
					</div>

					<div class="forgot-password-box">
						<span class="psw">Already have an account <a href="login_page.jsp">login?</a></span>
					</div>
				</form>

			</div>

		</div>
	</div>
</body>
</html>