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
import util.utilString;
import model.modelAdd;

@WebServlet(asyncSupported = true, urlPatterns = utilString.ADD_URL)
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class servletAdd extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private final connectdb connectDb;
	
	public servletAdd() {
		this.connectDb = new connectdb();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String CollegeName = request.getParameter("collegename");
	    String CollegeLocation = request.getParameter("location");
	    String CollegeDistrict = request.getParameter("district");
	    String Years = request.getParameter("year");
	    String GraduationRate = request.getParameter("graduationrate");
	    String AverageFee = request.getParameter("averagefee");
	    String CollegeWebsite = request.getParameter("website");
	    String CollegeContact = request.getParameter("collegecontact");
	    String CollegePhone = request.getParameter("collegephone");
	    String CollegeMail = request.getParameter("collegemail");
	    String Program = request.getParameter("program");
	    Part photos = request.getPart("image");
	    
	    modelAdd add = new  modelAdd(CollegeName, CollegeLocation, CollegeDistrict, Years, GraduationRate, AverageFee, CollegeWebsite, CollegeContact, CollegePhone, CollegeMail, Program, photos);
	    

	    int result = connectDb.modelAdd(add);

	    if (result == 1) {
	    	// Get the image file name from the student object (assuming it was extracted earlier)
	    		String fileName = add.getimageFromPart();

	    				// Check if a filename exists (not empty or null)
	    		if (!fileName.isEmpty() && fileName != null) {
	    				  // Construct the full image save path by combining the directory path and filename
	    			String savePath = utilString.IMAGE_PATH_COLLEGE;
	    			photos.write(savePath + fileName);  // Save the uploaded image to the specified path
	    		}
	    	// image upload code
	    	
			request.setAttribute(utilString.Sucess_Message, utilString.Sucessfully_Register);
			response.sendRedirect(request.getContextPath() + utilString.PANEL);

		} else if (result == 0) {
			System.out.println("Check the filled details!");
			request.setAttribute(utilString.Error_Message, utilString.Error_Register_Data);
			request.getRequestDispatcher(utilString.ADD).forward(request, response);
		} else {
			System.out.println(result);
			System.out.println("server error");
			request.setAttribute(utilString.Error_Message, utilString.Error_Server);
			request.getRequestDispatcher(utilString.ADD).forward(request, response);
		}
	}

}
