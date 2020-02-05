package com.project.shipticket.journey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.project.shipticket.user.TestConnection;

public class JourneyDAOImplementation implements journeyDAO {
	public void addJourney(Journey a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql1 = "insert into journey_detail values(?,?,?,?)";
		PreparedStatement smt1 = com.prepareStatement(sql1);
		smt1.setInt(1, a.journeyId);
		java.sql.Date date2 = java.sql.Date.valueOf(a.sourceDate);
		smt1.setDate(2, date2);
		java.sql.Date date3 = java.sql.Date.valueOf(a.destinationDate);
		smt1.setDate(3, date3);
		smt1.setInt(4, a.shipId);
		System.out.println(sql1);
		int row1 = smt1.executeUpdate();
		System.out.println(row1);

	}

	public void updateJourney(Journey a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql2 = "update journey_detail set destination_date=? where ship_id=?";
		PreparedStatement smt2 = com.prepareStatement(sql2);
		java.sql.Date date4 = java.sql.Date.valueOf(a.destinationDate);
		smt2.setDate(1, date4);
		smt2.setInt(2, a.shipId);
		System.out.println(sql2);

		int row2 = smt2.executeUpdate();
		System.out.println(row2);
	}

	public void deleteJourney(Journey a) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql3 = "delete from journey_detail  where ship_id=?";
		PreparedStatement smt3 = com.prepareStatement(sql3);
		smt3.setInt(1, a.shipId);
		System.out.println(sql3);

		int row3 = smt3.executeUpdate();
		System.out.println(row3);

	}
	public void getJourney(LocalDate date12,LocalDate date22) throws Exception
	{
		Connection com = TestConnection.getConnection();

		String sql4 = "select * from journey_detail where destination_date between ? and ?";
		PreparedStatement smt4 = com.prepareStatement(sql4);
		java.sql.Date date1 = java.sql.Date.valueOf(date12);
		smt4.setDate(1, date1);
		java.sql.Date date2 = java.sql.Date.valueOf(date22);
		smt4.setDate(2, date2);
		System.out.println(sql4);

		ResultSet rs4 = smt4.executeQuery();
		while (rs4.next()) {

			System.out.println("journeyid:" + rs4.getString("journey_id")+"\n");
			System.out.println("sourcedate:" + rs4.getString("source_date")+"\n");
			System.out.println("destinationdate:" + rs4.getString("destination_date")+"\n");
			System.out.println("ship_id:" + rs4.getString("ship_id")+"\n");
		}

	}

	
	
}