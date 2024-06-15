	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	    <%@page import="java.util.ArrayList"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<style>
	
	</style>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/head.css"  />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/index.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/footer.css" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
	<%@ include file="pages/header.jsp" %>
	<br/>
	
	<form>
	<div class="row">
	<div class="search col">
	<span class="search-icon material-symbols-outlined">Search</span>
	<input class="search-input"type="search" placeholder="Search" id="searchInput"><br/>
	</div>
	</div>
	</form>
	    <c:if test="${empty dataList}">
	        <p>No colleges found.</p>
	    </c:if>
	    <c:forEach var="college" items="${dataList}">
	        <div class="college-card">
	            <h2>${college.collegeName}</h2>
	            <p><strong>Location:</strong> ${college.collegeLocation}, ${college.collegeDistrict}</p>
	            <p><strong>Years:</strong> ${college.years}</p>
	            <p><strong>Graduation Rate:</strong> ${college.graduationRate}</p>
	            <p><strong>Average Fee:</strong> ${college.averageFee}</p>
	            <p><strong>Website:</strong> <a href="${college.collegeWebsite}">${college.collegeWebsite}</a></p>
	            <p><strong>Contact:</strong> ${college.collegeContact}, ${college.collegePhone}</p>
	            <p><strong>Email:</strong> <a href="mailto:${college.collegeMail}" class="email-link">${college.collegeMail}</a></p>
	            <p><strong>Program:</strong> ${college.program}</p>
	            <img src="${pageContext.request.contextPath}/resources/images/college/${college.imageFromPart}" alt="${college.imageFromPart}" height="200px">
	        </div>
	    </c:forEach>
	<%@ include file="pages/footer.jsp" %>
	
	<script>
    // JavaScript to handle the search functionality
    document.getElementById('searchForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Prevents the form from submitting and reloading the page
        var searchTerm = document.getElementById('searchInput').value.trim().toLowerCase();
        var colleges = document.getElementsByClassName('college-card');
        Array.from(colleges).forEach(function(college) {
            var collegeName = college.querySelector('h2').textContent.toLowerCase();
            if (collegeName.includes(searchTerm) || searchTerm === '') {
                college.style.display = 'block';
            } else {
                college.style.display = 'none';
            }
        });
    });
</script>
	
	</body>
	</html>