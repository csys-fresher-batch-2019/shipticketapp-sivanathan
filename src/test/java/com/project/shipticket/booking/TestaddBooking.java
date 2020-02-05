package com.project.shipticket.booking;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TestaddBooking {

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);
		System.out.println("select any one of the following(insert,update,delete,total)");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			method1();
		} else if (value.equalsIgnoreCase("update")) {
			method2();
		} else if (value.equalsIgnoreCase("delete")) {
			method3();
		} else if (value.equalsIgnoreCase("total")) {
			method5();
		}
		
		sa.close();
	}

	public static void method1() throws Exception {
		BookingDAOImplementation m1 = new BookingDAOImplementation();
		Booking u1 = new Booking();
		Scanner scn1 = new Scanner(System.in);
		System.out.println("ENTER THE INSERT VALUE DETAILS:\n");
		//System.out.println("Enter the bookingId:\n");
		//int bookingId = scn1.nextInt();
		System.out.println("Enter the userId:\n");

		int userId = scn1.nextInt();
		System.out.println("Enter the shipId:\n");
		int shipid = scn1.nextInt();
		System.out.println("Enter the journeyId:\n");
		int journeyId = scn1.nextInt();
		System.out.println("Enter the booking seats:\n");
		int bookingSeats = scn1.nextInt();
		// System.out.println("Enter the shipId:\n");
		// int shipId = scn1.nextInt();
		// String dateOfBooking=scn.next();//2020-01-01T20:00:00
		System.out.println("Enter the date of booking:\n");
		LocalDateTime date1 = /* LocalDateTime.parse(dateOfBooking); */LocalDateTime.now();
		// long contactNumber= scn.nextLong();
		System.out.println("Enter the status:\n");
		String status = scn1.next();
		System.out.println("Enter the cost:\n");
		int cost = scn1.nextInt();
		scn1.nextLine();
		// String classes = scn.nextLine();
		u1.shipId=shipid;
		u1.userId = userId;
		u1.journeyId = journeyId;
		u1.bookingSeats = bookingSeats;
		// u1.shipId = shipId;
		u1.dateOfBooking = date1;
		u1.status = status;
		u1.cost = cost;
		m1.addbooking(u1);
		scn1.close();
	}

	public static void method2() throws Exception {
		BookingDAOImplementation m2 = new BookingDAOImplementation();
		Booking u2 = new Booking();
		Scanner scn2 = new Scanner(System.in);

		System.out.println("ENTER THE UPDATE DETAILS:\n");
		System.out.println("Enter the status:\n");
		String status = scn2.next();
		System.out.println("Enter the userId:\n");
		int userId = scn2.nextInt();
		System.out.println("Enter the journeyId:\n");
		int Id = scn2.nextInt();
		u2.journeyId=Id;
		u2.userId = userId;
		u2.status = status;
		m2.updatebooking(u2);
		scn2.close();

	}

	public static void method3() throws Exception {
		BookingDAOImplementation m3 = new BookingDAOImplementation();
		Booking u3 = new Booking();
		Scanner scn3 = new Scanner(System.in);

		System.out.println("ENTER THE DELETE DETAILS:\n");
		System.out.println("Enter the userid:\n");
		int userId = scn3.nextInt();
		System.out.println("Enter the journeyid:\n");
		int jId = scn3.nextInt();
		u3.journeyId=jId;
		u3.userId = userId;
		m3.deletebooking(u3);
		scn3.close();

	}

		public static void method5() throws Exception {
		BookingDAOImplementation m5 = new BookingDAOImplementation();
		// ShipDetail u5 = new ShipDetail();
		Scanner scn5 = new Scanner(System.in);

		System.out.println("ENTER THE METHOD :\n");
		String value = scn5.next();
		m5.count(value);
		// u5.classes = classes;

		scn5.close();

	}

}