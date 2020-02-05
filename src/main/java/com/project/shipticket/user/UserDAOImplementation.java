
package com.project.shipticket.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAOImplementation implements UserDAO {

	public void addUser(User a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql = "insert into user_detail values(?,?,?,?,?,?,?)";
		PreparedStatement smt = com.prepareStatement(sql);
		smt.setString(1, a.userName);
		// smt.setString(1, a.getName());used for private condition
		smt.setInt(2, a.userId);
		java.sql.Date date1 = java.sql.Date.valueOf(a.dateOfBirth);
		smt.setDate(3, date1);
		smt.setLong(4, a.contactNumber);
		smt.setString(5, a.gender);
		smt.setString(6, a.password);
		smt.setString(7, a.email);
		System.out.println(sql);

		int row1 = smt.executeUpdate();
		System.out.println(row1);

		/*
		 * String sql1 =
		 * "select movie_ticket_cost from moviesname where movie_name=? AND movie_id=?";
		 * PreparedStatement smt = com.prepareStatement(sql);
		 * 
		 * ResultSet rs = smt.executeQuery(); while(rs.next()) {
		 * 
		 * System.out.println(rs.getInt("movie_ticket_cost"));
		 */
	}

	public void updateUser(User a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql1 = "update user_detail set contact_number=? where user_id=?";
		PreparedStatement smt1 = com.prepareStatement(sql1);
		smt1.setLong(1, a.contactNumber);
		smt1.setInt(2, a.userId);
		System.out.println(sql1);

		int row1 = smt1.executeUpdate();
		System.out.println(row1);
	}

	public void deleteUser(User a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql1 = "delete from user_detail  where user_id=?";
		PreparedStatement smt2 = com.prepareStatement(sql1);
		smt2.setInt(1, a.userId);
		System.out.println(sql1);

		int row2 = smt2.executeUpdate();
		System.out.println(row2);

	}

	public boolean user(String email, String password) throws Exception {

		Connection com = TestConnection.getConnection();
		Statement stmt6 = com.createStatement();
		if (stmt6.executeUpdate("select email from user_detail  where email='" + email + "'") != 0) {
			ResultSet rs = stmt6.executeQuery("select pass from user_detail  where email='" + email + "'");
			rs.next();

			if (password.equals(rs.getString("pass"))) {
				return true;
			}

		}
		return false;
	}

	public void resetUser(User a) throws Exception {
		Connection com3 = TestConnection.getConnection();

		String sql3 = "update user_detail set pass=? where user_id=?";
		PreparedStatement smt3 = com3.prepareStatement(sql3);
		smt3.setInt(2, a.userId);
		smt3.setString(1, a.password);
		System.out.println(sql3);

		int row3 = smt3.executeUpdate();
		System.out.println(row3);

	}
}
