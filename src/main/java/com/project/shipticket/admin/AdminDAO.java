package com.project.shipticket.admin;

import com.project.shipticket.util.DBException;

public interface AdminDAO {
//	public boolean admin(int adminId,String passWord );
	//public void  administration(int adminId,String passWord );
	public boolean AdminLogin(int adminId, String pass) throws DBException;
}
