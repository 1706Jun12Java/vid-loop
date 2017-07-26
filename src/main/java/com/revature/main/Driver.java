package com.revature.main;

import com.revature.dao.*;
import com.revature.domain.User;

public class Driver {

	public static void main(String[] args) {
		
		init();
	}
	static void init(){
		UserDao ud = new UserDaoImpl();
		
		User user1 = new User("user1","pass","user","user","user@gmail.com");
		
		ud.persistUser(user1);
	}
}
