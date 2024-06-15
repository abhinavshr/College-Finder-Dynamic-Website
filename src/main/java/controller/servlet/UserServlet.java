package controller.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("First_name");
        String lastName = request.getParameter("Last_name");
        String userName = request.getParameter("User_Name");
        String userEmail = request.getParameter("User_Email");
        String password = request.getParameter("Password");
        String image = request.getParameter("Image");

        // Store the user data in a session object
        HttpSession session = request.getSession();
        session.setAttribute("user", new User(firstName, lastName, userName, userEmail, password, image));

        // Redirect the user to the user info page
        response.sendRedirect("user.jsp");
    }
}