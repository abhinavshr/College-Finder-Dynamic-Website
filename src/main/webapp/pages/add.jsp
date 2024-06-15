<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="util.utilString"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/addded.css" />
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post" enctype="multipart/form-data" >
<h1>ADD</h1>
  <div class="roww">
    <div class="column">
      <label for="Collegename">College Name: </label>
      <input type="text" id="collegename" name="collegename" required>
    </div>
    <div class="column">
      <label for="location">Location: </label>
      <input type="text" id="location" name="location" required>
    </div>
    <div class="column">
      <label for="district">District: </label>
      <input type="text" id="district" name="district" required>
    </div>
    </div>
    <div class="roww">
    <div class="column">
      <label for="collegecontact">College Contact: </label>
      <input type="text" id="collegecontact" name="collegecontact" required>
    </div>
    <div class="column">
      <label for="collegephone">College Phone: </label>
      <input type="text" id="collegephone" name="collegephone" required>
    </div>
    <div class="column">
      <label for="collegemail">College Mail: </label>
      <input type="text" id="collegemail" name="collegemail" required>
    </div>
    </div>
  <div class="roww">
    <div class="column">
      <label for="year">Years: </label>
      <input type="text" id="year" name="year" required>
    </div>
    <div class="column">
      <label for="graduationrate">Graduation Rate</label>
      <input type="text" id="graduationrate" name="graduationrate" required>
    </div>
    <div class="column">
      <label for="averagefee">Average Fee: </label>
      <input type="text" id="averagefee" name="averagefee" required>
    </div>
  </div>
  <div class="roww">
    <div class="column">
      <label for="program">Program Offered:</label>
      <input type="text" id="program" name="program" >
    </div>
  </div>
  <div class="roww">
    <div class="column">
      <label for="website">Website:</label>
      <input type="text" id="website" name="website">
    </div>
  </div>
  <div class="roww">
			<div class="column">
				<label for="image">College Picture</label> <input type="file"
					id="image" name="image">
			</div>
		</div>
  <div class="button-container">
  <button type="submit" class="button">ADD</button>
</div>
</form>
</body>
</html>