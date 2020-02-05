package com.project.shipticket.booking;

public interface bookingDAO {

	public void addbooking(Booking b) throws Exception;

	public void updatebooking(Booking b) throws Exception;

	public void deletebooking(Booking b) throws Exception;
	
	
	public void count(String b) throws Exception;

}
