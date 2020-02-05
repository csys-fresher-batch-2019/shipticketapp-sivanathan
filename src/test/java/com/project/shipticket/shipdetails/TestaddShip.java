package com.project.shipticket.shipdetails;

import java.util.Scanner;

public class TestaddShip {

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);
		System.out.println("choose any of the following(insert or update or delete or getshipdetails  or distinct )");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			method1();
		} else if (value.equalsIgnoreCase("update")) {
			method2();
		} else if (value.equalsIgnoreCase("delete")) {
			method3();
		}else if (value.equalsIgnoreCase("getshipdetails")) {
			method4();}
		else if (value.equalsIgnoreCase("distinct")) {
			method5();}
		/*else if (value.equalsIgnoreCase("count")) {
			method6();}*/
		sa.close();
	}

	public static void method1() throws Exception {
		ShipDetailDAOImplementation m1 = new ShipDetailDAOImplementation();
		ShipDetail u1 = new ShipDetail();
		Scanner scn1 = new Scanner(System.in);
		System.out.println("ENTER THE INSERT VALUE DETAILS:\n");
		System.out.println("Enter the shipId:\n");
		int shipId = scn1.nextInt();
		System.out.println("Enter the shipname:\n");
		String shipName = scn1.next();
		System.out.println("Enter the sourceplace:\n");
		String sourcePlace = scn1.next();
		System.out.println("Enter the destination:\n");
		String destinationPlace = scn1.next();
		System.out.println("Enter the no of seats:\n");
		int noOfSeats = scn1.nextInt();
		scn1.nextLine();
		System.out.println("Enter the classes:\n");
		String classes = scn1.nextLine();
		System.out.println("Enter the amount:\n");
		int amount = scn1.nextInt();
		
		u1.shipId = shipId;
		u1.shipName = shipName;
		u1.sourcePlace = sourcePlace;
		u1.destinationPlace = destinationPlace;
		u1.noOfSeats = noOfSeats;
		u1.classes = classes;
		u1.amount = amount;
		m1.addship(u1);
		scn1.close();
	}

	public static void method2() throws Exception {
		ShipDetailDAOImplementation m2 = new ShipDetailDAOImplementation();
		ShipDetail u2 = new ShipDetail();
		Scanner scn2 = new Scanner(System.in);

		System.out.println("ENTER THE UPDATE DETAILS:\n");
		System.out.println("Enter the no of seats:\n");
		int noOfSeats = scn2.nextInt();
		System.out.println("Enter the ship id:\n");
		int shipId = scn2.nextInt();
		u2.noOfSeats =noOfSeats;
		u2.shipId = shipId;
		m2.updateship(u2);
		scn2.close();

	}

	public static void method3() throws Exception {
		ShipDetailDAOImplementation m3 = new ShipDetailDAOImplementation();
		ShipDetail u3 = new ShipDetail();
		Scanner scn3 = new Scanner(System.in);

		System.out.println("ENTER THE DELETE DETAILS:\n");
		System.out.println("Enter the shipid:\n");
		int id = scn3.nextInt();
		u3.shipId = id;
		m3.deleteship(u3);
		scn3.close();

	}

	public static void method4() throws Exception {
		ShipDetailDAOImplementation m4 = new ShipDetailDAOImplementation();
		ShipDetail u4 = new ShipDetail();
		Scanner scn4= new Scanner(System.in);

		System.out.println("ENTER THE SHIP  DETAILS:\n");
		System.out.println("Enter the ship id:\n");
		int id = scn4.nextInt();
		u4.shipId = id;
		m4.getship(u4);
		scn4.close();

	}
	public static void method5() throws Exception {
		ShipDetailDAOImplementation m5 = new ShipDetailDAOImplementation();
		//ShipDetail u5 = new ShipDetail();
		Scanner scn5= new Scanner(System.in);

		System.out.println("ENTER THE DISTINCT  DETAILS:\n");
		//System.out.println("Enter the classes:\n");
		String cl = scn5.next();
		//u5.classes = classes;
		m5.distinctship(cl);
		scn5.close();

	}/*
	public static void method6() throws Exception {
		ShipDetailDAOImplementation m6 = new ShipDetailDAOImplementation();
		ShipDetail u6 = new ShipDetail();
		Scanner scn6= new Scanner(System.in);

		System.out.println("ENTER THE COUNT  DETAILS:\n");
		//System.out.println("Enter the NO OF SEATS:\n");
		String seats = scn6.next();
		//u6.noOfSeats = ;
		//m6.countship(u6);
		scn6.close();*/

	}

