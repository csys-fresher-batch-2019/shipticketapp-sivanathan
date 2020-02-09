package com.project.shipticket.seatavailavility;

public class SeatAvailability {

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public int getAvailabilitySeats() {
		return availabilitySeats;
	}

	public void setAvailabilitySeats(int availabilitySeats) {
		this.availabilitySeats = availabilitySeats;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookingSeats() {
		return BookingSeats;
	}

	public void setBookingSeats(int bookingSeats) {
		BookingSeats = bookingSeats;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getShipNo() {
		return shipNo;
	}

	public void setShipNo(int shipNo) {
		this.shipNo = shipNo;
	}

	private int shipId;
	private int journeyId;
	private int availabilitySeats;
	private int userId;
	private int BookingSeats;
	private String ticketStatus;
	private int cost;
	private int shipNo;
	/*
	 * public String toString() { return "SeatAvailability [shipId=" + shipId +
	 * ", journeyId=" + journeyId + ", availabilitySeats=" + availabilitySeats +
	 * ", userId=" + userId + ", BookingSeats=" + BookingSeats + ", ticketStatus=" +
	 * ticketStatus + ", cost=" + cost + ", shipNo=" + shipNo + "]"; }
	 */

}
