package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/register")
public  class AddEmpServlet extends GenericServlet{
	public void service(ServletRequest rq ,ServletResponse rs)throws ServletException,IOException {
		PrintWriter pw=rs.getWriter();
		rs.setContentType("text/html");
		EmpBean pb = new EmpBean();//BeanClassObj
		pb.setFname(rq.getParameter("fname"));
		pb.setLname(rq.getParameter("lname"));
		pb.setEmail(rq.getParameter("email"));
		pb.setMoblleno(rq.getParameter("mnom"));
		pb.setDob(rq.getParameter("dob"));
		pb.setGender(rq.getParameter("gender"));
		pb.setAddres(rq.getParameter("address"));
		pb.setCountry(rq.getParameter("country"));
		pb.setCity(rq.getParameter("city"));
		String[] hob= rq.getParameterValues("skill");
		List a1=Arrays.asList(hob);
		pb.setSkill(a1.toString());
		int k=new InsertEmpDAO().insert(pb);
		RequestDispatcher rd = rq.getRequestDispatcher("home.jsp");
		rd.include(rq, rs);
		if(k>0) {
			pw.println("Product Added Successfully...<br>");
		}
		pw.close();
	}

}
