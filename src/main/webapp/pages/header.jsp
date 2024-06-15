<%@page import="util.utilString"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%> 

<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute("username");
    String contextPath = request.getContextPath();
%>

<div id="header">
    <header class="header">
        <ul class="main-nav">
            <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/review.jsp">Review</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/contactus.jsp">Contact Us</a></li>
            <li>
                <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + "/pages/user.jsp");
                    } else {
                        out.print(contextPath + "/pages/login.jsp");
                    }
                %>" method="post">
                    <input type="submit" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print("User");
                        } else {
                            out.print("User");
                        }
                    %>"/>
                </form>
            </li>
            
            <li>
                <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + utilString.LOGOUT_URL);
                    } else {
                        out.print(contextPath + "/pages/login.jsp");
                    }
                %>" method="post">
                    <input type="submit" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print("Logout");
                        } else {
                            out.print("Login");
                        }
                    %>"/>
                </form>
            </li>
        </ul>
    </header>
</div>