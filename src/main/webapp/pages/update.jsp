<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
<h1>UPDATE</h1>
  <div class="roww">
  <div class="column">
      <label for="collegeid">College ID: </label>
      <input type="text" id="collegeid" name="collegeid" required>
    </div>
    <div class="column">
      <label for="collegeName">College Name: </label>
      <input type="text" id="collegeName" name="collegeName" required>
    </div>
    <div class="column">
      <label for="locationU">Location: </label>
      <input type="text" id="locationU" name="locationU" required>
    </div>
    <div class="column">
      <label for="districtU">District: </label>
      <input type="text" id="districtU" name="districtU" required>
    </div>
    </div>
    <div class="roww">
    <div class="column">
      <label for="collegeContact">College Contact: </label>
      <input type="text" id="collegeContact" name="collegeContact" required>
    </div>
    <div class="column">
      <label for="collegePhone">College Phone: </label>
      <input type="text" id="collegePhone" name="collegePhone" required>
    </div>
    <div class="column">
      <label for="collegEmail">College Mail: </label>
      <input type="text" id="collegEmail" name="collegEmail" required>
    </div>
    </div>
  <div class="roww">
    <div class="column">
      <label for="yearU">Years: </label>
      <input type="text" id="yearU" name="yearU" required>
    </div>
    <div class="column">
      <label for="graduationRate">Graduation Rate</label>
      <input type="text" id="graduationRate" name="graduationRate" required>
    </div>
    <div class="column">
      <label for="averageFee">Average Fee: </label>
      <input type="text" id="averageFee" name="averageFee" required>
    </div>
  </div>
  <div class="roww">
    <div class="column">
      <label for="programU">Program Offered:</label>
      <input type="text" id="programU" name="programU">
    </div>
  </div>
  <div class="roww">
    <div class="column">
      <label for="websiteU">Website:</label>
      <input type="text" id="websiteU" name="websiteU">
    </div>
  </div>
  <div class="roww">
			<div class="column">
				<label for="imageU">College Picture</label> <input type="file"
					id="imageU" name="imageU">
			</div>
		</div>
  <div class="button-container">
  <button type="submit" class="button">Update</button>
</div>
</form>
</body>
</html>