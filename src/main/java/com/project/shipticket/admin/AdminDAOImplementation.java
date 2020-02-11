package com.project.shipticket.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.project.shipticket.util.Logger;
import com.project.shipticket.util.TestConnection;

public class AdminDAOImplementation implements AdminDAO {

	public boolean AdminLogin(int adminId, String pass) throws Exception

	{	Logger logger = Logger.getInstance();

		try {
			Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();
			String sql="select pass_word from AdminRegister where Admin_id=(select Admin_id from AdminRegister where Admin_id='"+adminId+"')";
			ResultSet rs1 = stmt.executeQuery(sql);
if(rs1.next())
{
String password=rs1.getString("pass_word");

if (pass.equals(password))
{
return true;
}
}

} 
		catch (Exception e) {
			logger.error("Exception"+e);
		}
		return false;
}
}



