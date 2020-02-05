package com.project.shipticket.seatavailavility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.shipticket.user.TestConnection;

public class SeatDAOImplementation implements SeatDAO {

	public void add(SeatAvailability a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql1 = "insert into seat_availability values(?,?,?)";
		PreparedStatement smt1 = com.prepareStatement(sql1);
		smt1.setInt(1, a.shipId);
		smt1.setInt(3, a.availabilitySeats);
		smt1.setInt(2, a.journeyId);
		System.out.println(sql1);
		int row = smt1.executeUpdate();
		System.out.println(row);

	}

	public void update(SeatAvailability a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql2 = "update seat_availability set available_seat=? where ship_id=? and journey_id=?";
		PreparedStatement smt2 = com.prepareStatement(sql2);
		smt2.setInt(1, a.availabilitySeats);
		smt2.setInt(2, a.shipId);
		smt2.setInt(3, a.journeyId);
		System.out.println(sql2);

		int row1 = smt2.executeUpdate();
		System.out.println(row1);
	}

	public void delete(SeatAvailability a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql3 = "delete from seat_availability  where ship_id=? and journey_id=?";
		PreparedStatement smt3 = com.prepareStatement(sql3);
		smt3.setInt(1, a.shipId);
		smt3.setInt(2, a.journeyId);
		System.out.println(sql3);

		int row2 = smt3.executeUpdate();
		System.out.println(row2);

	}
	
	public void procedure(SeatAvailability b) throws Exception
	{
		Connection com = TestConnection.getConnection();
		String sql4 ="call TICKET_BOOKING(?,?,?,?,?,?)";
	CallableStatement stmt=com.prepareCall(sql4);  
	stmt.setInt(1,b.userId);  
	stmt.setInt(2,b.shipNo);
	stmt.setInt(3,b.journeyId);
	stmt.setInt(4,b.BookingSeats);
	stmt.setString(5,b.ticketStatus);
	stmt.setInt(6,b.cost);
	System.out.println(sql4);

	stmt.executeQuery();  
	  
	System.out.println("success");  
		
	}	
	public void costofbooking(String b) throws Exception {
		Connection com = TestConnection.getConnection();
		String sql4 = "select " + b + "(cost)as cost from booking_detail";

		/*
		 * java.sql.Statement stmt=com.createStatement(); System.out.println(sql4);
		 * 
		 * 
		 * stmt.executeQuery(sql4);
		 */
		PreparedStatement smt4 = com.prepareStatement(sql4);

		ResultSet rs4 = smt4.executeQuery();
		if (rs4.next()) {

			System.out.println("cost:" + rs4.getInt("cost"));
		}

	}
	

}


