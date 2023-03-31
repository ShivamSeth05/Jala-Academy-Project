package test;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
public class RetriveEmpByCodeDAO  {

	public EmpBean pb = null;
	public EmpBean retrieve(ServletRequest rq) {
		try {
			Connection con = DBConnenction.getConnection();
			PreparedStatement ps = con.prepareStatement
			("select * from emplyee where fname=? and mnom=?");
			ps.setString(1, rq.getParameter("name"));
			ps.setString(2, rq.getParameter("number"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pb = new EmpBean();
				pb.setFname(rs.getString(1));
				pb.setLname(rs.getString(2));
				pb.setEmail(rs.getString(3));
				pb.setMoblleno(rs.getString(4));
				pb.setDob(rs.getString(5));
				pb.setGender(rs.getString(6));
				pb.setAddres(rs.getString(7));
				pb.setCountry(rs.getString(8));
				pb.setCity(rs.getString(9));
				String skil= rs.getString(10);
//				List a1=Arrays.asList(hob);
				pb.setSkill(skil);
			}
		}catch(Exception e) {e.printStackTrace();}
		return pb;
	}
}