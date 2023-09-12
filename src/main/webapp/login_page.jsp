<%@page import="com.learning.devops.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
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
				<form action="login" method="POST" class="login-form-box">
					<div class="form-title">
						<span>Login</span>
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
					
					
					<label for="useremail"><b>Email</b></label> <input type="text" class="input-field"
						placeholder="Enter emial" name="useremail"> <label
						for="userpassword"><b>Password</b></label> <input type="password" class="input-field"
						placeholder="Enter password" name="userpassword">

					<div class="submit-btn-box">
						<input type="submit" placeholder="login">
					</div>

					<div class="forgot-password-box">
						<span class="psw">Don't have an account? <a href="signup_page.jsp">SignUp</a></span>
					</div>
				</form>

			</div>

		</div>
	</div>
</body>
</html>