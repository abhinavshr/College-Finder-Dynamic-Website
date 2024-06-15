<!-- dashboard.jsp -->
<%@page import="java.util.ArrayList"%>
<%@page import="util.utilString"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dash Board</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/dashboard.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/footer.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<br/>
<h1>List of College</h1>
	<table id="college-table">
		<thead>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Location</th>
				<th>Years</th>
				<th>Graduation Rate</th>
				<th>Average Fee</th>
				<th>Website</th>
				<th>Contact</th>
				<th>Email</th>
				<th>Program</th>
				<th>Photo</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty dataList}">
				<tr>
					<td colspan="12">No user found.</td>
				</tr>
			</c:if>
			<c:forEach var="college" items="${dataList}">
				<tr>
					<td>${college.collegeId}</td>
					<td>${college.collegeName}</td>
					<td>${college.collegeLocation} ${college.collegeDistrict}</td>
					<td>${college.years}</td>
					<td>${college.graduationRate}</td>
					<td>${college.averageFee}</td>
					<td><a href="${college.collegeWebsite}">${college.collegeWebsite}</a></td>
					<td>${college.collegeContact} ${college.collegePhone}</td>
					<td>${college.collegeMail}</td>
					<td>${college.progarm}</td>
					<td><img src="${pageContext.request.contextPath}/resources/images/college/${college.imageFromPart}" height="100" alt="College Image"></td>
					<td>
							<form id="deleteForm-${college.collegeId}" method="post" action="${pageContext.request.contextPath}/LoginServlet">
    <input type="hidden" name="<%=utilString.DELETE %>" value="${college.collegeId}" />
    <button type="submit">Delete</button>
</form>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="${pageContext.request.contextPath}/pages/add.jsp"><button>ADD</button></a>
<%@ include file="footer.jsp" %>
</body>
</html>