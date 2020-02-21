package com.project.shipticket.booking;

public interface BookingDAO {

	public void addBooking(Booking b) throws Exception;//user work

	public void updateBooking(Booking b) throws Exception;//admin work

	public void deleteBooking(Booking b) throws Exception;//user work
	
	public int book(Booking b) throws Exception;
	public int count() throws Exception;//admin work

}
