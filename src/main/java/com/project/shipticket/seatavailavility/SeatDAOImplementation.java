package com.project.shipticket.seatavailavility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.shipticket.util.Logger;
import com.project.shipticket.util.TestConnection;

public class SeatDAOImplementation implements SeatDAO {
	Logger logger = Logger.getInstance();

	Connection com = null;

	public void add(SeatAvailability a) throws Exception {
		PreparedStatement smt1 = null;
		try {
			com = TestConnection.getConnection();
			String sql1 = "insert into seat_availability(ship_id,journey_id,available_seat) values(?,?,?)";
			smt1 = com.prepareStatement(sql1);
			smt1.setInt(1, a.getShipId());
			smt1.setInt(3, a.getAvailabilitySeats());
			smt1.setInt(2, a.getJourneyId());

			logger.debug(sql1);

			int row = smt1.executeUpdate();
			logger.debug(row);

		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt1 != null) {
				smt1.close();

			}
		}
	}

	public void update(SeatAvailability a) throws Exception {
		PreparedStatement smt2 = null;
		try {
			com = TestConnection.getConnection();
			String sql2 = "update seat_availability set available_seat=? where ship_id=? and journey_id=?";
			smt2 = com.prepareStatement(sql2);
			smt2.setInt(1, a.getAvailabilitySeats());
			smt2.setInt(2, a.getShipId());
			smt2.setInt(3, a.getJourneyId());
			logger.debug(sql2);

			int row1 = smt2.executeUpdate();
			logger.debug(row1);
		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt2 != null) {
				smt2.close();
				com.close();
			}
		}

	}

	public void delete(SeatAvailability a) throws Exception {
		PreparedStatement smt3 = null;
		try {
			com = TestConnection.getConnection();

			String sql3 = "delete from seat_availability  where ship_id=? and journey_id=?";
			smt3 = com.prepareStatement(sql3);
			smt3.setInt(1, a.getShipId());
			smt3.setInt(2, a.getJourneyId());
			logger.debug(sql3);

			int row2 = smt3.executeUpdate();
			logger.debug(row2);

		} catch (Exception e) {
			logger.error("Expection" + e);
		} finally {
			if (smt3 != null) {
				smt3.close();
				com.close();
			}
		}
	}

	public void procedure(SeatAvailability b) throws Exception {
		CallableStatement stmt = null;
		try {
			Connection com = TestConnection.getConnection();
			String sql4 = "call TICKET_BOOKING(?,?,?,?,?,?)";
			stmt = com.prepareCall(sql4);
			stmt.setInt(1, b.getUserId());
			stmt.setInt(2, b.getShipNo());
			stmt.setInt(3, b.getJourneyId());
			stmt.setInt(4, b.getBookingSeats());
			stmt.setString(5, b.getTicketStatus());
			stmt.setInt(6, b.getCost());
			stmt.executeQuery();
			/*
			 * ResultSet value=stmt.executeQuery(); System.out.println(sql4);
			 * while(value.next()) { System.out.println("cost:" + value.getInt("cost"));
			 * System.out.println("available seats:" + value.getInt("available_seats"));
			 * System.out.println("ticket status:" + value.getString("ticket_status")); }
			 */
		} catch (Exception e) {
			logger.error("exception" + e);
		} finally {
			if (stmt != null) {
				stmt.close();
				com.close();
			}
		}
	}

	public void costOfBooking(String b) throws Exception {
		PreparedStatement smt4 = null;
		try {
			com = TestConnection.getConnection();
			String sql4 = "select " + b + "(cost)as cost from booking_detail";
			smt4 = com.prepareStatement(sql4);

			ResultSet rs4 = smt4.executeQuery();
			if (rs4.next()) {

				logger.debug("cost:" + rs4.getInt("cost"));
			}

		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt4 != null) {
				smt4.close();
				com.close();
			}
		}

	}
}
