<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/loginn.css"  />
</head>
<body>
<div class="login-box">
		<h2>Login</h2>
		<form action="${pageContext.request.contextPath}/servletLogin" method="post">
			<div class="row">
				<div class="col">
					<label for="username">Username:</label> 
					<input type="text" id="username" name="username" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> 
					<input type="password" id="password" name="password" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
				<label for="register">Don't have an account <a href="${pageContext.request.contextPath}/pages/register.jsp">Sign Up?</a></label>
				</div>
			</div>
			<button type="submit" class="login-button">Login</button>
		</form>
	</div>
</body>
</html>