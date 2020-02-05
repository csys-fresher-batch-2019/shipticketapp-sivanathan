package com.project.shipticket.seatavailavility;

public interface SeatDAO {

	public void add(SeatAvailability b) throws Exception;

	public void update(SeatAvailability b) throws Exception;

	public void delete(SeatAvailability b) throws Exception;
	
	public void procedure(SeatAvailability b) throws Exception;
	
	public void costofbooking(String b) throws Exception;//procedure call
	
//public void count(SeatAvailability b) throws Exception;

}
