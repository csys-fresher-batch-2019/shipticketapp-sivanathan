
package com.project.shipticket.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.project.shipticket.util.Logger;
import com.project.shipticket.util.TestConnection;

public class UserDAOImplementation implements UserDAO {
	Logger logger = Logger.getInstance();
	PreparedStatement smt = null;

	// for adding the user details in sql.
	public void addUser(User a) throws Exception {
		Connection com = TestConnection.getConnection();
		try {
			String sql = "insert into user_detail(user_name,user_id,date_of_birth,contact_number,gender,pass,email) values(?,?,?,?,?,?,?)";

			smt = com.prepareStatement(sql);

			smt.setString(1, a.getUserName());
			smt.setInt(2, a.getUserId());
			java.sql.Date date1 = java.sql.Date.valueOf(a.getDateOfBirth());
			smt.setDate(3, date1);
			smt.setLong(4, a.getContactNumber());
			smt.setString(5, a.getGender());
			smt.setString(6, a.getPassword());
			smt.setString(7, a.getEmail());

			logger.info("sql statement:" + sql);
			// System.out.println(sql);

			int row1 = smt.executeUpdate();
			logger.info("NO OF ROWS INSERTED:" + row1);
			// System.out.println(row1);
			// smt.close();
		}

		catch (Exception e)

		{
			logger.error("Exception:" + e);
			// e.printStackTrace();

		} finally {
			try {
				if (smt != null) {
					smt.close();
					com.close();
				}
			} catch (Exception ex) {
				logger.error("Exception:" + ex);
			}
		}
	}

	// for update the user contact number using the user id.
	public void updateUser(User a) throws Exception {
		PreparedStatement smt1 = null;
		Connection com = TestConnection.getConnection();
		try {
			String sql1 = "update user_detail set contact_number=? where user_id=?";
			smt1 = com.prepareStatement(sql1);
			smt1.setLong(1, a.getContactNumber());
			smt1.setInt(2, a.getUserId());
			logger.info(sql1);

			int row1 = smt1.executeUpdate();
			logger.info(row1);
		}

		catch (Exception e) {
			logger.error("exception" + e);
		} finally {
			try {
				if (smt1 != null) {
					smt1.close();
					com.close();
				}
			} catch (Exception ex) {
				logger.error("Exception:" + ex);
			}
		}
	}

	// delete the user id from the sql.
	public void deleteUser(User a) throws Exception {
		PreparedStatement smt2 = null;
		Connection com = TestConnection.getConnection();
		try {

			String sql1 = "delete from user_detail  where user_id=?";
			smt2 = com.prepareStatement(sql1);
			smt2.setInt(1, a.getUserId());
			logger.info(sql1);

			int row2 = smt2.executeUpdate();
			logger.info(row2);
		} catch (Exception e) {
			logger.error("exception" + e);
		} finally {
			try {
				if (smt2 != null) {
					smt2.close();
					com.close();
				}
			} catch (Exception ex) {
				logger.error("Exception:" + ex);
			}
		}
	}

	// return whether the email and password is same for the login.
	public boolean User(String email, String password) throws Exception {
		Connection com = TestConnection.getConnection();
		Statement stmt6 = null;
		boolean result = false;
		ResultSet rs=null;
		try {
			stmt6 = com.createStatement();
			if (stmt6.executeUpdate("select email from user_detail  where email='" + email + "'") != 0) {
				rs = stmt6.executeQuery("select pass from user_detail  where email='" + email + "'");
				rs.next();

				if (password.equals(rs.getString("pass"))) {

					result = true;
					return result;
				}

			}

		} catch (Exception e) {
			logger.error("exception" + e);
		} finally {
			try {
				if (stmt6 != null) {
					stmt6.close();
					com.close();
					rs.close();
				}
			} catch (Exception ex) {
				logger.error("Exception:" + ex);
			}
		}
		return result;

	}

	// reset the password for the user if there is login failed
	public void resetUser(User a) throws Exception {
		PreparedStatement smt3 = null;
		Connection com = TestConnection.getConnection();
		try {

			String sql3 = "update user_detail set pass=? where user_id=?";
			smt3 = com.prepareStatement(sql3);
			smt3.setInt(2, a.getUserId());
			smt3.setString(1, a.getPassword());
			logger.info(sql3);

			int row3 = smt3.executeUpdate();
			logger.info(row3);

		} catch (Exception e) {
			logger.error("exception" + e);
		} finally {
			try {
				if (smt3 != null) {
					smt3.close();
					com.close();
				}
			} catch (Exception ex) {
				logger.error("Exception:" + ex);
			}
		}
	}
}
