package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		ArrayList<EmpBean>al = new RetrieveEmpDAO().retrieve();
		
		RequestDispatcher rd = req.getRequestDispatcher("search.html");
		rd.include(req, res);
		
		if(al.size()==0) {
			pw.println("<br>Emeloyee not available...<br>");
		}
		Iterator<EmpBean> at=al.iterator();
		while (at.hasNext()) {
			EmpBean pb = (EmpBean) at.next();
//			pw.println("<br>"+pb.getCode()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"
//			+pb.getDsg()+"&nbsp&nbsp"+pb.getBsal()+"&nbsp&nbsp"+pb.getTsal());
			pw.println("<br>"+pb.getFname()+"&nbsp&nbsp"+
					pb.getLname()+"&nbsp&nbsp"+pb.getEmail()+
					"&nbsp&nbsp"+pb.getMoblleno()+
					"&nbsp&nbsp"+pb.getDob()+
					"&nbsp&nbsp"+pb.getGender()+
					"&nbsp&nbsp"+pb.getAddres()+
					"&nbsp&nbsp"+pb.getCountry()+
					"&nbsp&nbsp"+pb.getCity()+
					"&nbsp&nbsp"+pb.getSkill());

		}
	}

}
