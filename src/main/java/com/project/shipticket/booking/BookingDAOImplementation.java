package com.project.shipticket.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.shipticket.util.ErrorMessages;
import com.project.shipticket.util.Logger;
import com.project.shipticket.util.TestConnection;

public class BookingDAOImplementation implements BookingDAO {
	Connection com = null;
	Logger logger = Logger.getInstance();

	public void addBooking(Booking a) throws Exception {
		// PreparedStatement smt1=null;
		try (Connection com = TestConnection.getConnection();) {

			String sql1 = "insert into booking_detail(booking_id,user_id,ship_id,journey_id,booking_seats,date_of_booking,ticket_status,cost) values(booking_id.nextval,?,?,?,?,?,?,?)";
			try (PreparedStatement smt1 = com.prepareStatement(sql1);) {

				// smt1.setInt(1, a.bookingId);
				smt1.setInt(1, a.getUserId());
				smt1.setInt(2, a.getShipId());
				smt1.setInt(3, a.getJourneyId());
				smt1.setInt(4, a.getBookingSeats());
				// smt1.setInt(5, a.shipId);
				java.sql.Timestamp date1 = java.sql.Timestamp.valueOf(a.getDateOfBooking());
				smt1.setTimestamp(5, date1);
				smt1.setString(6, a.getStatus());
				smt1.setInt(7, a.getCost());
				logger.debug(sql1);
				int row = smt1.executeUpdate();
				logger.debug(row);
			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT+ e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE+ e);
		}
	}

	public void updateBooking(Booking a) throws Exception {
		// PreparedStatement smt2 =null;
		try (Connection com = TestConnection.getConnection();) {

			String sql2 = "update booking_detail set ticket_status=? where user_id=? and journey_id=?";
			try (PreparedStatement smt2 = com.prepareStatement(sql2);) {

				smt2.setString(1, a.getStatus());
				smt2.setInt(2, a.getUserId());
				smt2.setInt(3, a.getJourneyId());
				logger.debug(sql2);
				int row1 = smt2.executeUpdate();
				logger.debug(row1);
			}  catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT+ e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE+ e);
		}
	}

	public void deleteBooking(Booking a) throws Exception {
		try (Connection com = TestConnection.getConnection();) {

			String sql3 = "delete from booking_detail  where user_id=? and journey_id=?";
			try (PreparedStatement smt3 = com.prepareStatement(sql3);) {
				smt3.setInt(1, a.getUserId());
				smt3.setInt(2, a.getJourneyId());
				System.out.println(sql3);

				int row2 = smt3.executeUpdate();
				logger.debug(row2);
			} catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT+ e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE+ e);
		}
	}

	public void count(String b) throws Exception {
		ResultSet rs4 = null;
		try (Connection com = TestConnection.getConnection();) {
			String sql4 = "select " + b + "(*) from booking_detail";
			try (PreparedStatement smt4 = com.prepareStatement(sql4);) {

				rs4 = smt4.executeQuery();
				if (rs4.next()) {

					logger.debug("count:" + rs4.getInt("count(*)"));
				}
			}  catch (Exception e) {
				logger.error(ErrorMessages.INVALID_PREPARESTATEMENT+ e);
			}
		} catch (Exception e) {
			logger.error(ErrorMessages.CONNECTION_FAILURE+ e);
		}
	}

}
