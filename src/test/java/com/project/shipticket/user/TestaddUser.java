package com.project.shipticket.user;

import java.time.LocalDate;
import java.util.*;
import com.project.shipticket.user.User;
import com.project.shipticket.user.UserDAOImplementation;

public class TestaddUser {

	public static void main(String[] args) throws Exception {
		Scanner sa = new Scanner(System.in);
		System.out.println("choose any of the following(login,insert,update,delete)");
		String value = sa.next();
		if (value.equalsIgnoreCase("insert")) {
			method1();
		} else if (value.equalsIgnoreCase("update")) {
			method2();
		} else if (value.equalsIgnoreCase("delete")) {
			method3();
		} else if (value.equalsIgnoreCase("login")) {
			userLogin();
		}
		sa.close();

	}

	public static void method1() throws Exception {

		UserDAOImplementation m1 = new UserDAOImplementation();
		User u1 = new User();
		Scanner scn1 = new Scanner(System.in);
		System.out.println("ENTER THE INSERT VALUE DETAILS:\n");
		System.out.println("Enter the userId:\n");
		int userId = scn1.nextInt();
		System.out.println("Enter the username:\n");
		String name = scn1.next();
		System.out.println("Enter the dob of user(YYYY-MM-DD):\n");
		String dob = scn1.next();// 2020-01-01
		LocalDate date = LocalDate.parse(dob);
		System.out.println("Enter the contact number:\n");
		long contactNumber = scn1.nextLong();
		System.out.println("Enter a gender(M/F):\n");
		String gender = scn1.next();
		System.out.println("Enter a password:\n");
		String password = scn1.next();
		System.out.println("Enter a email:\n");
		String email = scn1.next();

		scn1.close();
		u1.userId = userId;
		u1.userName = name;
		// u1.setName(name);//used for private to access
		u1.dateOfBirth = date;
		u1.contactNumber = contactNumber;
		u1.gender = gender;
		u1.password = password;
		u1.email = email;

		m1.addUser(u1);
	}

	// Date date = new Date();
	// SimpleDateFormat formatter = new SimpleDateFormat("01/11/1998");
	// String strDate= formatter.format(date);

	public static void method2() throws Exception {
		UserDAOImplementation m2 = new UserDAOImplementation();
		User u2 = new User();

		Scanner scn2 = new Scanner(System.in);

		System.out.println("ENTER THE UPDATE DETAILS:\n");
		System.out.println("Enter the contact number:\n");
		long number = scn2.nextLong();
		u2.contactNumber = number;
		System.out.println("Enter the userid:\n");
		int id = scn2.nextInt();
		u2.userId = id;
		scn2.close();
		m2.updateUser(u2);

	}

	public static void method3() throws Exception {
		UserDAOImplementation m3 = new UserDAOImplementation();
		User u3 = new User();

		Scanner scn3 = new Scanner(System.in);

		System.out.println("ENTER THE DELETE DETAILS:\n");
		System.out.println("Enter the userid:\n");
		int id = scn3.nextInt();
		u3.userId = id;

		scn3.close();
		m3.deleteUser(u3);

	}

	public static void userLogin() throws Exception {
		UserDAOImplementation m4 = new UserDAOImplementation();
		User u4 = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email :");
		String email = sc.next();
		System.out.println("Enter Password:");
		String password = sc.next();

		if (m4.user(email, password)) {
			System.out.println("----LOGIN SUCESSFULL----");
		} else {
			System.out.println("----LOGIN FAILED----");

			System.out.println("DO YOU WANT TO RESET PASSWORD(Y/N)");

			String reset = sc.next();
			if (reset.equalsIgnoreCase("Y")) {
				System.out.println("Enter the userid:\n");
				int id = sc.nextInt();
				u4.userId = id;
				System.out.println("Enter the new password:\n");
				String password1 = sc.next();
				u4.password = password1;
				sc.close();
				m4.resetUser(u4);
			} else {
				System.out.println("TRY AGAIN  ");
			}
		}
	}
}