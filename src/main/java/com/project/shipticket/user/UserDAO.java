package com.project.shipticket.user;

public interface UserDAO {

	public boolean user(String email, String password) throws Exception;

	public void addUser(User a /*
								 * int userId,String userName, String dateOfBirth,long contactNumber,String
								 * gender,String password
								 */) throws Exception;

	// select user_id,user_name,dob,contact_number,gender,pass from addUser;

	public void updateUser(User a) throws Exception;

	public void deleteUser(User a) throws Exception;
	
	public void resetUser(User a) throws Exception;
}

/*
 * public void userName(String name);
 * 
 * public void dateOfBirth(int number);
 * 
 * public void contact(long number);
 * 
 * public void gender(String name);
 * 
 * public void pass(String name); String output="userId:" +userId+
 * " username:"+userName+" dob:"+dateOfBirth+" contactnumber:"
 * +contactNumber+" gender:"gender+" password:"+password;
 */
