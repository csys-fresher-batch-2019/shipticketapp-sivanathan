package com.project.shipticket.user;

public interface UserDAO {

	public boolean User(String email, String password) throws Exception;

	public void addUser(User a) throws Exception;

	public void updateUser(User a) throws Exception;

	public void deleteUser(User a) throws Exception;

	public void resetUser(User a) throws Exception;
}
