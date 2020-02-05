package com.project.shipticket.user;

//import java.sql.Date;
import java.time.LocalDate;

public class User {
	/*
	 * user_name varchar2(20) not null, user_id number, date_of_birth date not null,
	 * contact_number number not null, gender varchar2(2) not null, pass
	 * varchar2(20) not null,
	 */
	// private String userName;
	public String userName;
	public int userId;
	public LocalDate dateOfBirth;
	public long contactNumber;
	public String gender;
	public String password;
	public String email;

}
