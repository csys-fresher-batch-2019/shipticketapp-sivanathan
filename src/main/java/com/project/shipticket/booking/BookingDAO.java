package com.project.shipticket.booking;

public interface BookingDAO {

	public void addBooking(Booking b) throws Exception;//user work

	public void updateBooking(Booking b) throws Exception;//admin work

	public void deleteBooking(Booking b) throws Exception;//user work
	
	
	public void count(String b) throws Exception;//admin work

}
