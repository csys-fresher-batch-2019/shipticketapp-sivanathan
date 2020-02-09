package com.project.shipticket.shipdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.shipticket.util.Logger;
import com.project.shipticket.util.TestConnection;

public class ShipDetailDAOImplementation {
	Logger logger = Logger.getInstance();
	Connection com = null;

	public void addShip(ShipDetail s) throws Exception {
		PreparedStatement smt = null;
		try {
			com = TestConnection.getConnection();
			String sql = "insert into ship_detail(ship_id,ship_name,source_place,destination_place,total_no_of_seats,classes,amount) values(?,?,?,?,?,?,?)";
			smt = com.prepareStatement(sql);

			smt.setInt(1, s.getShipId());
			smt.setString(2, s.getShipName());
			smt.setString(3, s.getSourcePlace());
			smt.setString(4, s.getDestinationPlace());
			smt.setInt(5, s.getNoOfSeats());
			smt.setString(6, s.getClasses());
			smt.setInt(7, s.getAmount());

			logger.info(sql);

			int row = smt.executeUpdate();

			logger.info(row);
		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt != null) {
				smt.close();
				com.close();
			}
		}
	}

	public void updateShip(ShipDetail s) throws Exception {
		PreparedStatement smt1 = null;
		try {
			com = TestConnection.getConnection();
			String sql1 = "update ship_detail set total_no_of_seats=? where ship_id=?";

			smt1 = com.prepareStatement(sql1);

			smt1.setInt(1, s.getNoOfSeats());
			smt1.setInt(2, s.getShipId());

			logger.info(sql1);

			int row1 = smt1.executeUpdate();
			logger.info(row1);
		} catch (Exception e) {
			logger.error("Exception" + e);
		} finally {
			if (smt1 != null) {
				smt1.close();
				com.close();
			}
		}
	}

	public void deleteShip(ShipDetail s) throws Exception {
		PreparedStatement smt2 = null;
		try {
			com = TestConnection.getConnection();

			String sql2 = "delete from ship_detail  where ship_id=?";
			smt2 = com.prepareStatement(sql2);

			smt2.setInt(1, s.getShipId());
			logger.info(sql2);

			int row2 = smt2.executeUpdate();
			logger.info(row2);

		} catch (Exception e) {
			logger.info("Exception" + e);
		} finally {
			if (smt2 != null) {
				smt2.close();
				com.close();
			}

		}
	}

	public void getShip(ShipDetail s) throws Exception {
		PreparedStatement smt3 = null;
		try {
			com = TestConnection.getConnection();

			String sql3 = "select source_place,destination_place from ship_detail where ship_id=?";
			smt3 = com.prepareStatement(sql3);
			smt3.setInt(1, s.getShipId());
			ResultSet rs = smt3.executeQuery();

			if (rs.next()) {

				logger.info("sourceplace:" + rs.getString("source_place"));
				logger.info("destinationplace:" + rs.getString("destination_place"));
			}
		} catch (Exception e) {
			logger.info("Exception" + e);
		} finally {
			if (smt3 != null) {
				smt3.close();
				com.close();
			}
		}
	}

	public void distinctShip(String s) throws Exception {
		PreparedStatement smt4 = null;
		try {
			com = TestConnection.getConnection();

			String sql4 = "select distinct(" + s + ") as classes from ship_detail";
			smt4 = com.prepareStatement(sql4);

			ResultSet rs4 = smt4.executeQuery();
			while (rs4.next()) {

				logger.info(rs4.getString("classes"));
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