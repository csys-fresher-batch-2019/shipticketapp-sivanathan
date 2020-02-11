package com.project.shipticket.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.shipticket.util.Logger;
import com.project.shipticket.util.TestConnection;


public class BookingDAOImplementation implements BookingDAO {
	Connection com =null;
	Logger logger = Logger.getInstance();
	public void addBooking(Booking a) throws Exception {
		PreparedStatement smt1=null; 
		try{
			com = TestConnection.getConnection();
			String sql1 = "insert into booking_detail(booking_id,user_id,ship_id,journey_id,booking_seats,date_of_booking,ticket_status,cost) values(booking_id.nextval,?,?,?,?,?,?,?)";
		smt1 = com.prepareStatement(sql1);
		//smt1.setInt(1, a.bookingId);
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
		logger.debug(row);}
		catch(Exception e)
		{
			logger.error("Exception"+e);
		}
		finally
		{
			if(smt1!=null)
			{
				smt1.close();
				com.close();
			}
		}
	}

	public void updateBooking(Booking a) throws Exception {
		PreparedStatement smt2 =null;
		try{
			com = TestConnection.getConnection();

		String sql2 = "update booking_detail set ticket_status=? where user_id=? and journey_id=?";
		smt2 = com.prepareStatement(sql2);
		smt2.setString(1, a.getStatus());
		smt2.setInt(2, a.getUserId());
		smt2.setInt(3, a.getJourneyId());
		logger.debug(sql2);
		int row1 = smt2.executeUpdate();
		logger.debug(row1);}
		catch(Exception e)
		{
			logger.error("exception"+e);
		}
		finally
		{
			if(smt2!=null)
			{
				smt2.close();
				com.close();
			}
		}

	}

	public void deleteBooking(Booking a) throws Exception {
		PreparedStatement smt3=null;
		try {
		com = TestConnection.getConnection();

		String sql3 = "delete from booking_detail  where user_id=? and journey_id=?";
		smt3 = com.prepareStatement(sql3);
		smt3.setInt(1, a.getUserId());
		smt3.setInt(2, a.getJourneyId());
		System.out.println(sql3);

		int row2 = smt3.executeUpdate();
		logger.debug(row2);}
		catch(Exception e)
		{
			logger.error("Exception"+e);
		}
		finally
		{
			if(smt3!=null)
			{
				smt3.close();
				com.close();
			}
		}

	}

		public void count(String b) throws Exception {
			PreparedStatement smt4 =null;
			ResultSet rs4=null;
			try{com = TestConnection.getConnection();
		String sql4 = "select " + b + "(*) from booking_detail";
		smt4 = com.prepareStatement(sql4);

		rs4 = smt4.executeQuery();
		if (rs4.next()) {

			logger.debug("count:" + rs4.getInt("count(*)"));
		}}
			catch(Exception e)
			{
				logger.error("Exception"+e);
			}
			finally
			{
				if(smt4!=null)
				{
					smt4.close();
					com.close();
					rs4.close();
				}
			}

	}


	
}
