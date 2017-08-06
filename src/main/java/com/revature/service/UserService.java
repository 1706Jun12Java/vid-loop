package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class UserService {

	@Autowired
	UserDaoImpl VD;
	
	public User getUserById(int id){
		return VD.getUserById(id);
	}

}