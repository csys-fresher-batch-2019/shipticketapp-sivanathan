package com.project.shipticket.user;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class TestConnection {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		return con;
	}

}
