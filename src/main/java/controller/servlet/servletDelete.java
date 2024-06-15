package controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerr.database.connectdb;
import util.utilString;

@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class servletDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final connectdb connectDb;

    public servletDelete() {
        this.connectDb = new connectdb();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deleteId = request.getParameter(utilString.DELETE);

        if (deleteId != null && !deleteId.isEmpty()) {
            doDelete(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter(utilString.DELETE);

        if (deleteId != null && !deleteId.isEmpty()) {
            System.out.println("Delete triggered for ID: " + deleteId);

            if (connectDb.deleteCollege(deleteId) == 1) {
                req.setAttribute(utilString.Sucess_Message, utilString.MESSAGE_SUCCESS_DELETE);
            } else {
                req.setAttribute(utilString.Error_Message, utilString.MESSAGE_ERROR_DELETE);
            }
        } else {
            req.setAttribute(utilString.Error_Message, "College ID is missing for deletion.");
        }

        // Redirect to panel page
        resp.sendRedirect(req.getContextPath() + utilString.PANEL);
    }
}
