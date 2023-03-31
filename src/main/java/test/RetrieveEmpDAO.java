package test;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class RetrieveEmpDAO {
	public ArrayList<EmpBean> al = new ArrayList<EmpBean>();//Created with size=0
	public  ArrayList<EmpBean> retrieve() {
		
		try {
			Connection con=DBConnenction.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emplyee");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				EmpBean pb= new EmpBean(); 
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
				al.add(pb);//Bean object added to ArrayList
			}//end of loop
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}
//	private in
	
}
