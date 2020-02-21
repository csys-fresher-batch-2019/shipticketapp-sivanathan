package com.project.shipticket.user;

import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface UserDAO {
/*
	@SqlUpdate("insert into user_detail(user_name,user_id,date_of_birth,contact_number,gender,pass,email) values(?,?,?,?,?,?,?)")
	void addUser(User a);
	
	@SqlUpdate("update user_detail set contact_number=? where user_id=?")
	void updateUser(User a);
	
	@SqlUpdate("delete from user_detail  where user_id=?")
	void deleteUser(User a);
	
	@SqlUpdate("update user_detail set pass=? where user_id=?")
	void resetUser(User a);
	
	
	*/
	
	public boolean User(int userId, String password) throws Exception;

	public void addUser(User a) throws Exception;//user

	public void updateUser(User a) throws Exception;//user

	public void deleteUser(User a) throws Exception;//admin

	public void resetUser(User a) throws Exception;//user
}
