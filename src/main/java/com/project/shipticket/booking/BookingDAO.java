package com.project.shipticket.booking;

public interface BookingDAO {

	public void addBooking(Booking b) throws Exception;

	public void updateBooking(Booking b) throws Exception;

	public void deleteBooking(Booking b) throws Exception;
	
	
	public void count(String b) throws Exception;

}
