package com.project.shipticket.journey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.project.shipticket.util.Logger;
import com.project.shipticket.util.TestConnection;

public class JourneyDAOImplementation implements JourneyDAO {
	Connection com = null;
	Logger logger = Logger.getInstance();

	public void addJourney(Journey a) throws Exception {
		PreparedStatement smt1 = null;
		try {
			com = TestConnection.getConnection();
			String sql1 = "insert into journey_detail(journey_id,source_date,destination_date,ship_id)values(?,?,?,?)";
			smt1 = com.prepareStatement(sql1);
			smt1.setInt(1, a.getJourneyId());
			java.sql.Date date2 = java.sql.Date.valueOf(a.getSourceDate());
			smt1.setDate(2, date2);
			java.sql.Date date3 = java.sql.Date.valueOf(a.getDestinationDate());
			smt1.setDate(3, date3);
			smt1.setInt(4, a.getShipId());
			logger.debug(sql1);
			int row1 = smt1.executeUpdate();
			logger.debug(row1);
		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt1 != null) {
				smt1.close();
				com.close();
			}
		}
	}

	public void updateJourney(Journey a) throws Exception {
		PreparedStatement smt2 = null;
		try {
			com = TestConnection.getConnection();
			String sql2 = "update journey_detail set destination_date=? where ship_id=?";
			smt2 = com.prepareStatement(sql2);
			java.sql.Date date4 = java.sql.Date.valueOf(a.getDestinationDate());
			smt2.setDate(1, date4);
			smt2.setInt(2, a.getShipId());
			logger.debug(sql2);

			int row2 = smt2.executeUpdate();
			logger.debug(row2);
		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt2 != null) {
				smt2.close();
				com.close();
			}
		}
	}

	public void deleteJourney(Journey a) throws Exception {
		PreparedStatement smt3 = null;
		try {
			com = TestConnection.getConnection();

			String sql3 = "delete from journey_detail  where ship_id=?";
			smt3 = com.prepareStatement(sql3);
			smt3.setInt(1, a.getShipId());
			logger.debug(sql3);

			int row3 = smt3.executeUpdate();
			logger.debug(row3);
		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt3 != null) {
				smt3.close();
				com.close();
			}
		}

	}

	public void getJourney(LocalDate date12, LocalDate date22) throws Exception {
		PreparedStatement smt4 = null;
		ResultSet rs4 =null;
		try {
			com = TestConnection.getConnection();

			String sql4 = "select * from journey_detail where destination_date between ? and ?";
			smt4 = com.prepareStatement(sql4);
			java.sql.Date date1 = java.sql.Date.valueOf(date12);
			smt4.setDate(1, date1);
			java.sql.Date date2 = java.sql.Date.valueOf(date22);
			smt4.setDate(2, date2);
			logger.debug(sql4);

			rs4 = smt4.executeQuery();
			while (rs4.next()) {

				logger.debug("journeyid:" + rs4.getString("journey_id") + "\n");
				logger.debug("sourcedate:" + rs4.getString("source_date") + "\n");
				logger.debug("destinationdate:" + rs4.getString("destination_date") + "\n");
				logger.debug("ship_id:" + rs4.getString("ship_id") + "\n");
			}
		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt4 != null) {
				smt4.close();
				com.close();
				rs4.close();
			}
		}
	}

}