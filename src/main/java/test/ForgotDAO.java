package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;

public class ForgotDAO {
	private Connection conn;
	UserBean user=null;
	public UserBean forgot(ServletRequest req) {
		try {
			conn=DBConnenction.getConnection();
			PreparedStatement ps1=conn.prepareStatement
					("select * from users where email=?");
			ps1.setString(1, req.getParameter("femail"));
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {
				user=new UserBean();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		 
	}
}
