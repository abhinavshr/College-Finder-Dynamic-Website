package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerr.database.connectdb;
import model.modelReview;
import util.utilString;


@WebServlet(asyncSupported = true, urlPatterns = "/reviewcollege" )
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ServletReviewSave extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final connectdb connectDb;
	
	public ServletReviewSave() {
		this.connectDb = new connectdb();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve form parameters using correct names
	    String FullName = request.getParameter("FullName");
	    String Rating = request.getParameter("Rating");
	    String Review = request.getParameter("Review");
	    
	    // Check if any parameter is null
	    if (FullName == null || Rating == null || Review == null) {
	        // Handle the case where any parameter is null
	        System.out.println("One or more form parameters are null.");
	        // You might want to redirect or forward the user to an error page here
	        return;
	    }
	    
	    // Create modelReview object
	    modelReview regi = new modelReview(FullName, Rating, Review);
	    
	    // Call the modelReview method of connectDb
	    int result = connectDb.modelReview(regi);

	    // Handle the result of the operation
	    if (result == 1) {
	        request.setAttribute(utilString.Sucess_Message, utilString.Sucessfully_Register);
	        response.sendRedirect(request.getContextPath() + utilString.REVIEW);
	    } else if (result == 0) {
	        System.out.println("Check the filled details!");
	        request.setAttribute(utilString.Error_Message, utilString.Error_Register_Data);
	        request.getRequestDispatcher(utilString.REVIEW).forward(request, response);
	    } else {
	        System.out.println(result);
	        System.out.println("server error");
	        request.setAttribute(utilString.Error_Message, utilString.Error_Server);
	        request.getRequestDispatcher(utilString.REVIEW).forward(request, response);
	    }
	}

}

