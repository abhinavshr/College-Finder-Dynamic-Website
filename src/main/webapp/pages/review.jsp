<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/head.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/review.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/footer.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<%@ include file="header.jsp" %>
  <header>
    <h1>College Reviews</h1>
    <p>Share your thoughts about your college</p>
  </header>
  <c:if test="${empty dataList}">
	        <p>No colleges found.</p>
	    </c:if>
	    <c:forEach var="college" items="${dataList}">
  <section id="college-list">
    <div class="college">
      <h2>${college.collegeName}</h2>
      <p>Location: ${college.collegeLocation}, ${college.collegeDistrict}</p>
      <p>Website: <a href="${college.collegeWebsite}">${college.collegeWebsite}</a></p>
      <img src="${pageContext.request.contextPath}/resources/images/college/${college.imageFromPart}" alt="College Image" height="300px">
      <form action="${pageContext.request.contextPath}/reviewcollege" method="post">
      <div class="review-form">
        <label for="review-name">Your Name:</label>
        <input type="text" id="FullName" name="FullName" required>
        <label for="review-rating">Rating:</label>
        <select id="Rating" name="Rating" required>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
        <label for="review-text">Review:</label>
        <textarea id="Review" name="Review" required></textarea>
        <button type="submit">Submit Review</button>  
      </div>
      </form>
    </div>
    </section>
    </c:forEach>
<%@ include file="footer.jsp" %>
</body>
</html>