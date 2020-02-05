package com.project.shipticket.journey;

import java.time.LocalDate;
import java.util.Scanner;

public class TestaddJourney {

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);
		System.out.println("insert or update or delete or getdate");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			method1();
		} else if (value.equalsIgnoreCase("update")) {
			method2();
		} else if (value.equalsIgnoreCase("delete")) {
			method3();
		}else if (value.equalsIgnoreCase("getdate")) {
				method4();
			}
			
		sa.close();
	}

	public static void method1() throws Exception {
		JourneyDAOImplementation m1 = new JourneyDAOImplementation();
		Journey u1 = new Journey();
		Scanner scn1 = new Scanner(System.in);
		System.out.println("ENTER THE INSERT VALUE DETAILS:\n");
		//System.out.println("Enter the userId:\n");

	//	int userId = scn1.nextInt();
		System.out.println("Enter the journeyId:\n");
		int journeyId = scn1.nextInt();
		System.out.println("Enter the journey source date:\n");
		String date1 = scn1.next();// 2020-01-01
		LocalDate date = LocalDate.parse(date1);
		System.out.println("Enter the journey destination date:\n");
		String date3 = scn1.next();// 2020-01-01
		LocalDate date2 = LocalDate.parse(date3);
		System.out.println("Enter the shipId:\n");
		int shipId = scn1.nextInt();

//		u1.userId = userId;
		u1.journeyId = journeyId;
		u1.sourceDate = date;
		u1.destinationDate = date2;
		u1.shipId = shipId;

		scn1.close();
		m1.addJourney(u1);
	}

	public static void method2() throws Exception {
		JourneyDAOImplementation m2 = new JourneyDAOImplementation();
		Journey u2 = new Journey();
		Scanner scn2 = new Scanner(System.in);

		System.out.println("ENTER THE UPDATE DETAILS:\n");
		System.out.println("Enter the destination date:\n");
		String date5 = scn2.next();// 2020-01-01
		LocalDate date6 = LocalDate.parse(date5);
		System.out.println("Enter the ship Id:\n");
		int shipId = scn2.nextInt();
		
		u2.shipId = shipId;
		u2.destinationDate = date6;
		m2.updateJourney(u2);
		
		scn2.close();

	}

	public static void method3() throws Exception {
		JourneyDAOImplementation m3 = new JourneyDAOImplementation();
		Journey u3 = new Journey();
		Scanner scn3 = new Scanner(System.in);

		System.out.println("ENTER THE DELETE DETAILS:\n");
		System.out.println("Enter the ship id:\n");
		int id = scn3.nextInt();
		
		u3.shipId = id;
		m3.deleteJourney(u3);
		
		scn3.close();

	}
	public static void method4() throws Exception {
		JourneyDAOImplementation m4 = new JourneyDAOImplementation();
		//Journey u4 = new Journey();
		Scanner scn4 = new Scanner(System.in);

		System.out.println("ENTER THE DESTINATION FROM DATE AND DESTINATION TO DATE DETAILS:\n");
		System.out.println("Enter the from date(YYYY-MM-DD):\n");
		String dob = scn4.next();// 2020-01-01
		LocalDate date1 = LocalDate.parse(dob);
		System.out.println("Enter the to date(YYYY-MM-DD):\n");
		String dob1 = scn4.next();// 2020-01-01
		LocalDate date2 = LocalDate.parse(dob1);
		
		//u4.journeyId = id;
		m4.getJourney(date1,date2);
		
		scn4.close();

	}

}