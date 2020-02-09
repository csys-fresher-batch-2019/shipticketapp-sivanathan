package com.project.shipticket.util;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class TestConnection {
	public static Connection getConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
