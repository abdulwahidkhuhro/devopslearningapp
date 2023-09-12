<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<jsp:include page="links.jsp" />
</head>
<body>
	<div class="container">
		<div class="home-page-navbar">
			<div>
				<span class="navbar-devops">Devops</span><span
					class="navbar-learning">Learning</span>
			</div>
			<div>
				<div class="user-profile-btn">
					<img alt="" src="./icons/profile-icon.png">
				</div>
				<div class="user-profile-drop-down">
					<form action="">
						<label for="uname"><b>Name</b></label><br /> <input type="text"
							placeholder="Name" name="uname" disabled="disabled"> <br />
						<label for="uemail"><b>Email</b></label><br /> <input type="text"
							placeholder="Email" name="unam" uemail"e" disabled="disabled">
						<br />
						<button class="log-out" type="submit">Log out</button>
					</form>
				</div>
			</div>
		</div>
		<div class="home-page-body">
			<div class="bg-image-container">
				<img alt="" src="./icons/devops-logo.png">
			</div>
			<div class="body-box">

				<p class="welcome-title">Welcome, Ali</p>
				<h1 class="home-question">What is DevOps?</h1>
				<div class="devops-paragraph-box">
					<p class="devops-paragraph">DevOps, short for Development and
						Operations, is a transformative approach to software development
						and IT operations that focuses on collaboration, automation, and
						continuous improvement. In a nutshell, DevOps bridges the
						traditional gap between development (creating software) and
						operations (deploying and maintaining software) teams to enhance
						the efficiency, speed, and quality of software delivery.</p>
				</div>
				
				
				
			</div>

		</div>
		
	</div>
</body>
</html>