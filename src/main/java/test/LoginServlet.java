package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/user-login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("index.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter pw=resp.getWriter()){

		UserBean ub= new LoginDAO().userLogin(req);
		
		if(ub!=null) {
			req.getSession().setAttribute("admin", ub);
			resp.sendRedirect("home.jsp");
		}
		else {
			pw.println(" <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>"
	    			+ "  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>");
			pw.println("<div class='alert alert-danger alert-dismissible'>");
			pw.println(" <button type='button' class='btn-close' data-bs-dismiss='alert'></button>");
			pw.println("<strong>Sorry!</strong> Login Failed.");
			pw.println("</div>");
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	
	

}
