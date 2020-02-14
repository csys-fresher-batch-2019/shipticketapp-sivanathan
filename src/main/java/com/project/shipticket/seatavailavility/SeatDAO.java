package com.project.shipticket.seatavailavility;

public interface SeatDAO {

	public void add(SeatAvailability b) throws Exception;//admin work

	public void update(SeatAvailability b) throws Exception;//admin work

	public void delete(SeatAvailability b) throws Exception;//admin work

	public void procedure(SeatAvailability b) throws Exception;// procedure call

	public void costOfBooking(String b) throws Exception;
	
	public int seat(SeatAvailability b)throws Exception;

	// public void count(SeatAvailability b) throws Exception;

}
