package com.revature.dao;

import com.revature.domain.*;

public interface UserDao {

	public void persistUser(User user);
	public User getUserById(int id);
}
