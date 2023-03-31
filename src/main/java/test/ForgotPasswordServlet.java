
package test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;



@SuppressWarnings("serial")
@WebServlet("/Forgot")
public class ForgotPasswordServlet extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	  response.setContentType("Text/Html");
    // Retrieve email address from form data
//    String email = request.getParameter("email");
    
//System.out.println(email);
	  PrintWriter pw=response.getWriter();
		UserBean ub= new ForgotDAO().forgot(request);
		System.out.println(ub);
		pw.println("Your Email is "+ub.getEmail());
		pw.println("<br> And Your password is "+ub.getPassword());
		RequestDispatcher rd= request.getRequestDispatcher("forgot.jsp");
		rd.include(request, response);
    
  }


}

