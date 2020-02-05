package com.project.shipticket.shipdetails;

public class ShipDetail {
	/*
	 * user_id number, ship_id number not null, ship_type varchar2(20) not null,
	 * source_place varchar2(50)not null, destination_place varchar2(50)not null,
	 * no_of_seats number not null, classes varchar2(20) not null,
	 */

	public int shipId;
	public String shipName;
	public String sourcePlace;
	public String destinationPlace;
	public int noOfSeats;
	public String classes;
	public int amount;
}
