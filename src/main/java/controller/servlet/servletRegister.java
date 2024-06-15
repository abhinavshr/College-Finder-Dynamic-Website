package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controllerr.database.connectdb;
import model.registerModel;
import util.utilString;


@WebServlet(asyncSupported = true, urlPatterns = { utilString.REGISTER_URL })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class servletRegister extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private final connectdb connectDb;
	
	public servletRegister() {
		this.connectDb = new connectdb();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String Firstname = request.getParameter("firstName");
	    String Lastname = request.getParameter("lastName");
	    String UserName = request.getParameter("username");
	    String UserEmail = request.getParameter("email");
	    String Password = request.getParameter("password");
	    Part Image = request.getPart("Image");
	    
	    registerModel regi = new  registerModel(Firstname, Lastname, UserName, UserEmail, Password, Image);
	    

	    int result = connectDb.registerModel(regi);

	    if (result == 1) {
	    	
	    	String fileName = regi.getimageUrlFromPart();

			// Check if a filename exists (not empty or null)
	if (!fileName.isEmpty() && fileName != null) {
			  // Construct the full image save path by combining the directory path and filename
		String savePath = utilString.IMAGE_PATH_USER;
		Image.write(savePath + fileName);  // Save the uploaded image to the specified path
	}
			request.setAttribute(utilString.Sucess_Message, utilString.Sucessfully_Register);
			response.sendRedirect(request.getContextPath() + utilString.Login_URL);

		} else if (result == 0) {
			System.out.println("Check the filled details!");
			request.setAttribute(utilString.Error_Message, utilString.Error_Register_Data);
			request.getRequestDispatcher(utilString.Register_URL).forward(request, response);
		} else {
			System.out.println(result);
			System.out.println("server error");
			request.setAttribute(utilString.Error_Message, utilString.Error_Server);
			request.getRequestDispatcher(utilString.Register_URL).forward(request, response);
		}
	}

}
