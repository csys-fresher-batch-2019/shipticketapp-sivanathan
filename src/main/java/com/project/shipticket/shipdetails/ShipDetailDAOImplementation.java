package com.project.shipticket.shipdetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.shipticket.user.TestConnection;

public class ShipDetailDAOImplementation {
	public void addship(ShipDetail s/*
									 * int userId,int shipId,String shipType,String sourcePlace,String
									 * destinationPlace,int noOfSeats,String classes
									 */) throws Exception {
		Connection com = TestConnection.getConnection();
		String sql = "insert into ship_detail values(?,?,?,?,?,?,?)";
		PreparedStatement smt = com.prepareStatement(sql);
		smt.setInt(1, s.shipId);
		smt.setString(2, s.shipName);
		smt.setString(3, s.sourcePlace);
		smt.setString(4, s.destinationPlace);
		smt.setInt(5, s.noOfSeats);
		smt.setString(6, s.classes);
		smt.setInt(7, s.amount);
		System.out.println(sql);
		int row = smt.executeUpdate();
		System.out.println(row);
	}

	public void updateship(ShipDetail s) throws Exception {
		Connection com = TestConnection.getConnection();
		String sql1 = "update ship_detail set total_no_of_seats=? where ship_id=?";
		//String sql1 = "select distinct ? from ship;";
		PreparedStatement smt1 = com.prepareStatement(sql1);
		smt1.setInt(1, s.noOfSeats);
		smt1.setInt(2, s.shipId);
		System.out.println(sql1);

		int row1 = smt1.executeUpdate();
		System.out.println(row1);
	}

	public void deleteship(ShipDetail s) throws Exception {
		Connection com = TestConnection.getConnection();

		String sql2 = "delete from ship_detail  where ship_id=?";
		PreparedStatement smt2 = com.prepareStatement(sql2);
		
		smt2.setInt(1, s.shipId);
		System.out.println(sql2);

		int row2 = smt2.executeUpdate();
		System.out.println(row2);

	}
	public void getship(ShipDetail s) throws Exception{
		Connection com = TestConnection.getConnection();

		String sql3 = "select source_place,destination_place from ship_detail where ship_id=?";
		PreparedStatement smt3 = com.prepareStatement(sql3);
		//System.out.println(sql3);
		smt3.setInt(1, s.shipId);
		ResultSet rs = smt3.executeQuery();
		
		if (rs.next()) {

			System.out.println("sourceplace:" + rs.getString("source_place"));
			System.out.println("destinationplace:" + rs.getString("destination_place"));
		}}
		public void distinctship(String s)throws Exception{
			Connection com = TestConnection.getConnection();

			String sql4 = "select distinct("+ s +") as classes from ship_detail";
			PreparedStatement smt4 = com.prepareStatement(sql4);
			
			ResultSet rs4 = smt4.executeQuery();
			while (rs4.next()) {

				System.out.println( rs4.getString("classes"));
			}

		}
		/*public void countship(ShipDetail s)throws Exception{
			Connection com = TestConnection.getConnection();

			String sql4 = "select COUNT(?)from ship";
			PreparedStatement smt4 = com.prepareStatement(sql4);
			smt4.setInt(1, s.noOfSeats);
			ResultSet rs4 = smt4.executeQuery();
			while (rs4.next()) {

				System.out.println("classes:" + rs4.getString("classes"));
			}*/

		}

	

