package com.project.shipticket.seatavailavility;

import java.util.Scanner;

public class TestAddSeat 

{
	public static void main(String[] args) throws Exception {
	Scanner sa = new Scanner(System.in);
	System.out.println("select any one of the following(insert,update,delete,cost,procedure)");
	String value = sa.next();
	if (value.equalsIgnoreCase("insert")) {
		method1();
	} else if (value.equalsIgnoreCase("update")) {
		method2();
	} else if (value.equalsIgnoreCase("delete")) {
		method3();
	} else if (value.equalsIgnoreCase("cost")) {
		method4();
	}
	else if (value.equalsIgnoreCase("procedure")) {
			method6();
	}
	
	sa.close();
}

public static void method1() throws Exception {
	SeatDAOImplementation m1 = new SeatDAOImplementation();
	SeatAvailability u1 = new SeatAvailability();
	Scanner scn1 = new Scanner(System.in);
	System.out.println("ENTER THE INSERT VALUE DETAILS:\n");
	System.out.println("Enter the shipId:\n");
	int sId = scn1.nextInt();
	System.out.println("Enter the journeyId:\n");
	int jId = scn1.nextInt();
	System.out.println("Enter the availabilitySeats:\n");
	int Seats = scn1.nextInt();
	u1.shipId = sId;
	u1.journeyId = jId;
	u1.availabilitySeats=Seats;
	m1.add(u1);
	scn1.close();
}

public static void method2() throws Exception {
	SeatDAOImplementation m2 = new SeatDAOImplementation();
	SeatAvailability u2 = new SeatAvailability();
	Scanner scn2 = new Scanner(System.in);

	System.out.println("ENTER THE UPDATE DETAILS:\n");
	System.out.println("Enter the availabilitySeats:\n");
	int status = scn2.nextInt();
	System.out.println("Enter the shipId:\n");
	int Id = scn2.nextInt();
	System.out.println("Enter the journeyId:\n");
	int Idj = scn2.nextInt();
	u2.availabilitySeats=status;
	u2.journeyId = Idj;
	u2.shipId = Id;
	m2.update(u2);
	scn2.close();

}

public static void method3() throws Exception {
	SeatDAOImplementation m3 = new SeatDAOImplementation();
	SeatAvailability u3 = new SeatAvailability();
	Scanner scn3 = new Scanner(System.in);

	System.out.println("ENTER THE DELETE DETAILS:\n");
	System.out.println("Enter the shipid:\n");
	int Id = scn3.nextInt();
	System.out.println("Enter the journeyid:\n");
	int Ijd = scn3.nextInt();
	u3.shipId=Id;
	u3.journeyId = Ijd;
	m3.delete(u3);
	scn3.close();

}

public static void method4() throws Exception {
	SeatDAOImplementation m4 = new SeatDAOImplementation();
	// ShipDetail u5 = new ShipDetail();
	Scanner scn4 = new Scanner(System.in);

	System.out.println("ENTER THE ANY OF METHOD FOR COST:\n");
	System.out.println("sum or min or max or avg ");
	// System.out.println("Enter the classes:\n");
	String value = scn4.next();
	if (value.equalsIgnoreCase("sum")) {
		m4.costofbooking(value);
	} else if (value.equalsIgnoreCase("min")) {
		m4.costofbooking(value);
	} else if (value.equalsIgnoreCase("max")) {
		m4.costofbooking(value);
	} else if (value.equalsIgnoreCase("avg")) {
		m4.costofbooking(value);
	}

	// u5.classes = classes;

	scn4.close();

}

public static void method6() throws Exception //procedure call
{
	SeatDAOImplementation m6 = new SeatDAOImplementation();
	SeatAvailability u6 = new SeatAvailability();
	Scanner scn6 = new Scanner(System.in);

	System.out.println("ENTER THE PROCEDURE CALL DETAILS:\n");
	System.out.println("Enter the userid:\n");
	int Id = scn6.nextInt();
	System.out.println("Enter the ship no:\n");
	int Ijd = scn6.nextInt();
	System.out.println("Enter the journey id:\n");
	int jjd = scn6.nextInt();
	System.out.println("Enter the booking seats:\n");
	int bjd = scn6.nextInt();
	System.out.println("Enter the ticket status:\n");
	String tjd = scn6.next();
	System.out.println("Enter the cost:\n");
	int cjd = scn6.nextInt();
	u6.cost=cjd;
	u6.ticketStatus=tjd;
	u6.BookingSeats=bjd;
	u6.journeyId=jjd;
	u6.shipNo=Id;
	u6.journeyId = Ijd;
	m6.procedure(u6);
	scn6.close();

}


}