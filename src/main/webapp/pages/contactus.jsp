<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/head.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/contactus.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/footer.css" />
</head>
<body>
<%@ include file="header.jsp" %>
<!-- Hero Section -->
<section class="hero">
  <div class="background-image"></div>
  <h1>Get in Touch with Us</h1>
  <p>We're here to help you find your perfect college match</p>
</section>

<!-- Contact Information Section -->
<section class="contact-info">
  <h2>Contact Information</h2>
  <p>Address: Madhyapur thimi, Bode- 8</p>
  <p>Phone Number: <a href="tel:9849808773" class="phone-number">Phone Number: 9849808773</a>,  <a href="tel:9827622357" class="phone-number">9827622357</a></p>
  <p>Email: <a href="mailto:collegefinder.info@gmail.com" class="email-link">collegefinder.info@gmail.com</a></p>
</section>

<!-- Contact Form Section -->
<section class="contact-form">
  <h2>Send Us a Message</h2>
  <form action="../contactus" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br><br>
    <label for="phone">Phone Number:</label>
    <input type="tel" id="phone" name="phone"><br><br>
    <label for="message">Message:</label>
    <textarea id="message" name="message"></textarea><br><br>
    <button class="cta">Submit</button>
  </form>
</section>

<!-- FAQ Section -->
<section class="faq">
  <h2>Frequently Asked Questions</h2>
  <ul>
    <li>
      <h3>What is College Finder?</h3>
      <p>College Finder is a website that helps you find your perfect college match.</p>
    </li>
    <li>
      <h3>How do I use College Finder?</h3>
      <p>Simply enter your preferences and we'll match you with colleges that fit your needs.</p>
    </li>
    <li>
      <h3>What colleges do you partner with?</h3>
      <p>We partner with over 100 colleges and universities across the country.</p>
    </li>
  </ul>
</section>

<!-- Visual Cues Section -->
<section class="visual-cues">
  <i class="fas fa-graduation-cap"></i>
  <i class="fas fa-book"></i>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>