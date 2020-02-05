package com.project.shipticket.shipdetails;

public interface ShipDetailDAO {

	public void addship(ShipDetail s/*
									 * int userId,int shipId,String shipType,String sourcePlace,String
									 * destinationPlace,int noOfSeats,String classes
									 */);

	public void updateship(ShipDetail s);

	public void deleteship(ShipDetail s);
	
	public void getship(ShipDetail s);
	
	public void distinctship(ShipDetail s);//used for differentiate in classes in sql
	
	//public void countship(ShipDetail s);

}

/*
 * public void ship(int userId,int shipId,String shipType,String
 * sourcePlace,String destinationPlace,int noOfSeats,String classes);
 * 
 * /*user_id number, ship_id number not null, ship_type varchar2(20) not null,
 * source_place varchar2(50)not null, destination_place varchar2(50)not null,
 * no_of_seats number not null, classes varchar2(20) not null,
 */
