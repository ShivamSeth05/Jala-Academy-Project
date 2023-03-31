package test;

import java.sql.*;

public class InsertEmpDAO {
	public int k=0;
	public int insert(EmpBean pb) {

		try {
			Connection con =DBConnenction.getConnection();//Accessing DB Connection
			PreparedStatement ps=con.prepareStatement("insert into emplyee values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, pb.getFname());
			ps.setString(2, pb.getLname());
			ps.setString(3, pb.getEmail());
			ps.setString(4, pb.getMoblleno());
			ps.setString(5, pb.getDob());
			ps.setString(6, pb.getGender());
			ps.setString(7, pb.getAddres());
			ps.setString(8, pb.getCountry());
			ps.setString(9, pb.getCity());
			ps.setString(10,pb.getSkill());
			
			k = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}
}
