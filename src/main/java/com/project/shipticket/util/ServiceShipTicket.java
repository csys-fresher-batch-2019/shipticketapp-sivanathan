package com.project.shipticket.util;

import java.time.LocalDate;

import com.project.shipticket.admin.AdminDAO;
import com.project.shipticket.admin.AdminDAOImplementation;
import com.project.shipticket.booking.Booking;
import com.project.shipticket.booking.BookingDAO;
import com.project.shipticket.booking.BookingDAOImplementation;
import com.project.shipticket.journey.Journey;
import com.project.shipticket.journey.JourneyDAO;
import com.project.shipticket.journey.JourneyDAOImplementation;
import com.project.shipticket.seatavailavility.SeatAvailability;
import com.project.shipticket.seatavailavility.SeatDAO;
import com.project.shipticket.seatavailavility.SeatDAOImplementation;
import com.project.shipticket.shipdetails.ShipDetail;
import com.project.shipticket.shipdetails.ShipDetailDAO;
import com.project.shipticket.shipdetails.ShipDetailDAOImplementation;
import com.project.shipticket.user.User;
import com.project.shipticket.user.UserDAO;
import com.project.shipticket.user.UserDAOImplementation;


//it is used when client is not necessary to call DAO directly instead we using one service class to call all the DAO .So that service will call the DAO and return the statement to client through servelet.
public class ServiceShipTicket {
	private AdminDAO admin = new AdminDAOImplementation();
	private SeatDAO seat = new SeatDAOImplementation();
	private BookingDAO book = new BookingDAOImplementation();
	private JourneyDAO journey=new JourneyDAOImplementation();
	private ShipDetailDAO ship=new ShipDetailDAOImplementation();
	private UserDAO user=new UserDAOImplementation();
	
	public boolean AdminLogin(int adminId, String pass) throws Exception {
		return admin.AdminLogin(adminId, pass);
	}

	public void add(SeatAvailability a) throws Exception {
		seat.add(a);
	}

	public void update(SeatAvailability a) throws Exception {
		seat.update(a);
	}
	public void delete(SeatAvailability a) throws Exception {
		seat.delete(a);
	}
	public void procedure(SeatAvailability b) throws Exception {
		seat.procedure(b);
	}
	public void costOfBooking(String b) throws Exception {
		seat.costOfBooking(b);
	}
	public void addBooking(Booking a) throws Exception {
		book.addBooking(a);
	}
	public void updateBooking(Booking a) throws Exception {
		book.updateBooking(a);
	}
	public void deleteBooking(Booking a) throws Exception {
		book.deleteBooking(a);
	}
	public void count(String b) throws Exception {
		book.count(b);
	}
	public void addJourney(Journey a) throws Exception {
	journey.addJourney(a);
	}
	public void updateJourney(Journey a) throws Exception {
		journey.updateJourney(a);
	}
	public void deleteJourney(Journey a) throws Exception {
		journey.deleteJourney(a);
	}
	
	public void getJourney(LocalDate date12, LocalDate date22) throws Exception {
		journey.getJourney(date12, date22);
	}
	public void addShip(ShipDetail s) throws Exception {
		ship.addShip(s);
	}
	public void updateShip(ShipDetail s) throws Exception {
		ship.updateShip(s);
	}
	public void deleteShip(ShipDetail s) throws Exception {
		ship.deleteShip(s);
	}
	public void getShip(ShipDetail s) throws Exception {
		ship.getShip(s);
	}
	public void distinctShip(String s) throws Exception {
		ship.distinctShip(s);
	}
	public void addUser(User a) throws Exception {
		user.addUser(a);
	}
	public void updateUser(User a) throws Exception {
		user.updateUser(a);
	}
	public void deleteUser(User a) throws Exception {
		user.deleteUser(a);
	}
	public boolean User(String email, String password) throws Exception {
		return user.User(email, password);
	}
	public void resetUser(User a) throws Exception {
		user.resetUser(a);
	}
	
}

