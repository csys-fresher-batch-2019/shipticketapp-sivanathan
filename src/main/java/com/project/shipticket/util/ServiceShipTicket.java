package com.project.shipticket.util;

import java.time.LocalDate;
import java.util.ArrayList;

import org.jdbi.v3.core.Jdbi;

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
	private JourneyDAO journey = new JourneyDAOImplementation();
	private ShipDetailDAO ship = new ShipDetailDAOImplementation();
	private UserDAO user = new UserDAOImplementation();
	//static Jdbi jdbi=TestConnection.getJdbi();
	//static UserDAO user=jdbi.onDemand(UserDAO.class);
	public int Totalcost(int a,int b)throws Exception{
		return seat.Totalcost(a,b);	
	}
	

	public boolean AdminLogin(int adminId, String pass) throws ServiceException {
		boolean adminLogin = false;
		try {
			validSearch(adminId, pass);
			adminLogin = admin.AdminLogin(adminId, pass);
		} catch (ValidatorException e) {
			throw new ServiceException("validator exception is achieved " + e);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("DB exception is achieved " + e);
		}

		return adminLogin;

	}

	public boolean User(int userId, String password) throws Exception {
		boolean userLogin = false;
		try {
			validSearch1(userId, password);
			userLogin = user.User(userId, password);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException("validator exception is achieved " + e);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("DB exception is achieved " + e);
		}

		return userLogin;

	}

	public int book(Booking b) throws Exception{
		return book.book(b);
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

	public int costOfBooking(String b) throws Exception {
		 return seat.costOfBooking(b);
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

	public int count() throws Exception {
		return book.count();
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

	public ArrayList<Journey> getJourney(int a) throws Exception {
		 return journey.getJourney( a);
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

	public ArrayList<ShipDetail> getShip(ShipDetail s) throws Exception {
		 return ship.getShip(s);
	}
	
	public ArrayList<ShipDetail> Ship() throws Exception {
		 return ship.Ship();
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

	public void resetUser(User a) throws Exception {
		user.resetUser(a);
	}

	public int seat(SeatAvailability b) throws Exception {
		return seat.seat(b);
	}

	public void validSearch(int adminId, String pass) throws ValidatorException {
		if (adminId == 0) {
			throw new ValidatorException("Invalid admin");

		} else if (pass == null || pass.equals("") || pass.trim().equals("")) {
			throw new ValidatorException("Invalid password");
		}
	}

	public void validSearch1(int userId, String password) throws ValidatorException {
		if (userId==0) {
			throw new ValidatorException("Invalid userid");

		} else if (password == null || password.equals("") || password.trim().equals("")) {
			throw new ValidatorException("Invalid password");
		}
	}

}
