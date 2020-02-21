package com.project.shipticket.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
//import java.sql.SQLException;

public class TestConnection {
	public static Connection getConnection() throws Exception {
		Logger logger = Logger.getInstance();
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (Exception e) {
			logger.error("Exception"+e);
		}

		return con;
	}//ctrl+shift+o to add all import
	public static Jdbi getJdbi()
	{
		Jdbi jdbi=null;
		Connection connection;
		try {
			connection = getConnection();
			jdbi=Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return jdbi;
	}
}
