package controller.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllerr.database.connectdb;
import model.modelLogin;
import util.utilString;

@WebServlet(urlPatterns = "/servletLogin", asyncSupported = true)
public class servletLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private final connectdb connectDb;

    public servletLogin() {
        this.connectDb = new connectdb();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract username and password from the request parameters
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a LoginModel object to hold user credentials
        modelLogin loginModel = new modelLogin(userName, password);

        try {
            // Call DBController to validate login credentials
            int loginResult = connectDb.loginInfo(loginModel);

            // Handle login results with appropriate messages and redirects
            if (loginResult == 1) {
                // Login successful
                HttpSession userSession = request.getSession();
                userSession.setAttribute("username", userName);
                userSession.setMaxInactiveInterval(30 * 30);

                Cookie userCookie = new Cookie("user", userName);
                userCookie.setMaxAge(30 * 60);
                response.addCookie(userCookie);

                // Check if the logged-in user is an admin
                int isAdmin = connectDb.adminOrNot(userName);
                if (isAdmin == 1) {
                    // Redirect to panel.jsp for admin
                    response.sendRedirect(request.getContextPath() + "/pages/panel.jsp");
                } else {
                    // Redirect to another page for non-admin users
                    response.sendRedirect(request.getContextPath() + utilString.WELCOME);
                }
            } else if (loginResult == 0) {
                // Username or password mismatch
                request.setAttribute(utilString.Error_Message, utilString.Error_Login);
                request.getRequestDispatcher(utilString.Login_URL).forward(request, response);
            } else if (loginResult == -1) {
                // Username not found
                request.setAttribute(utilString.Error_Message, utilString.Create_Account_Error);
                request.getRequestDispatcher(utilString.Login_URL).forward(request, response);
            } else {
                // Internal server error
                request.setAttribute(utilString.Error_Message, utilString.Server_Error);
                request.getRequestDispatcher(utilString.Login_URL).forward(request, response);
            }
        } catch (Exception e) {
            // Other unexpected errors
            request.setAttribute(utilString.Error_Message, "Unexpected Error: Please contact the administrator.");
            request.getRequestDispatcher(utilString.Login_URL).forward(request, response);
            e.printStackTrace();
        }
    }


}
