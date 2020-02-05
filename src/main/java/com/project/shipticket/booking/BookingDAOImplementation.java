package com.project.shipticket.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.shipticket.user.TestConnection;

public class BookingDAOImplementation implements bookingDAO {

	public void addbooking(Booking a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql1 = "insert into booking_detail values(booking_id.nextval,?,?,?,?,?,?,?)";
		PreparedStatement smt1 = com.prepareStatement(sql1);
		//smt1.setInt(1, a.bookingId);
		smt1.setInt(1, a.userId);
		smt1.setInt(2, a.shipId);
		smt1.setInt(3, a.journeyId);
		smt1.setInt(4, a.bookingSeats);
		// smt1.setInt(5, a.shipId);
		java.sql.Timestamp date1 = java.sql.Timestamp.valueOf(a.dateOfBooking);
		smt1.setTimestamp(5, date1);
		smt1.setString(6, a.status);
		smt1.setInt(7, a.cost);
		System.out.println(sql1);
		int row = smt1.executeUpdate();
		System.out.println(row);

	}

	public void updatebooking(Booking a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql2 = "update booking_detail set ticket_status=? where user_id=? and journey_id=?";
		PreparedStatement smt2 = com.prepareStatement(sql2);
		smt2.setString(1, a.status);
		smt2.setInt(2, a.userId);
		smt2.setInt(3, a.journeyId);
		System.out.println(sql2);

		int row1 = smt2.executeUpdate();
		System.out.println(row1);
	}

	public void deletebooking(Booking a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql3 = "delete from booking_detail  where user_id=? and journey_id=?";
		PreparedStatement smt3 = com.prepareStatement(sql3);
		smt3.setInt(1, a.userId);
		smt3.setInt(2, a.journeyId);
		System.out.println(sql3);

		int row2 = smt3.executeUpdate();
		System.out.println(row2);

	}

		public void count(String b) throws Exception {
		Connection com = TestConnection.getConnection();
		String sql4 = "select " + b + "(*) from booking_detail";

		/*
		 * java.sql.Statement stmt=com.createStatement(); System.out.println(sql4);
		 * 
		 * 
		 * stmt.executeQuery(sql4);
		 */
		PreparedStatement smt4 = com.prepareStatement(sql4);

		ResultSet rs4 = smt4.executeQuery();
		if (rs4.next()) {

			System.out.println("count:" + rs4.getInt("count(*)"));
		}

	}


	
}
