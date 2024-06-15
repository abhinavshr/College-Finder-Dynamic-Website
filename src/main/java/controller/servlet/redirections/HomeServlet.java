package controller.servlet.redirections;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerr.database.connectdb;
import model.modelHome;


@WebServlet(asyncSupported = true, urlPatterns =  "/index.jsp")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	connectdb cn = new connectdb();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet invoked ----------------------------");
		ArrayList<modelHome> dataList;
		try {
			dataList = cn.getDatabaseData();
			request.setAttribute("dataList", dataList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", "Class Not FOund error");
			}
		request.getRequestDispatcher("/home").forward(request, response);
	}

}