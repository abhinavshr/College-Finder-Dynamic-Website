<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/regi.css"  />
</head>
<body>

<div class="container">
	<h1>Registration Form</h1>
	<form action="../register" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col">
				<label for="firstName">First Name:</label> <input type="text"
					id="firstName" name="firstName" required>
			</div>
			<div class="col">
	<label for="lastName">Last Name:</label> <input type="text"
					id="lastName" name="lastName" required>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" required>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="col">
				<label for="retypePassword">Retype Password:</label> <input
					type="password" id="retypePassword" name="retypePassword" required>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="image">Profile Picture</label> <input type="file"
					id="image" name="Image">
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="Login">Already Have an Acoount <a href="${pageContext.request.contextPath}/pages/login.jsp"> Login?</a></label>
			</div>
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
</body>
</html>