package com.project.shipticket.user;

public interface UserDAO {

	public boolean User(int userId, String password) throws Exception;

	public void addUser(User a) throws Exception;//user

	public void updateUser(User a) throws Exception;//user

	public void deleteUser(User a) throws Exception;//admin

	public void resetUser(User a) throws Exception;//user
}
