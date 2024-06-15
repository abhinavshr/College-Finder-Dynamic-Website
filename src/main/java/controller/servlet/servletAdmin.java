package controller.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerr.database.connectdb;
import model.modelAdmin;

/**
 * Servlet implementation class servletAdmin
 */
@WebServlet("/servletAdmin")
public class servletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create an instance of the connectdb class
		connectdb db = new connectdb();
//
//		// Declare an ArrayList to store the data
//		
//
//			// Call the getDataFromDatabase() method
		ArrayList<modelAdmin> dataList = new ArrayList<>();
		try {
			dataList = db.getDataFromDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//
//			// Add the ArrayList to the request
		request.setAttribute("dataList", dataList);
		request.getRequestDispatcher(request.getContextPath()+"/pages/panel.jsp").forward(request, response);
		// Use the RequestDispatcher to forward the request and response
		// request.getRequestDispatcher("collegefinder/pages/admindash.jsp").forward(request,
		// response);

	}

}
