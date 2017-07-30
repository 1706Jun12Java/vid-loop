package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void persistUser(User user) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
	}

	@Override
	public User getUserById(int id) {
		Session session = ConnectionUtil.getSession();
		User user = (User) session.get(User.class, id);
	    session.close();
	      return user;
	}

}
