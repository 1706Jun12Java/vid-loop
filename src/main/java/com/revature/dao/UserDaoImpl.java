package com.revature.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {

	private static Logger log = Logger.getRootLogger();

	@Override
	public void persistUser(User user) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		log.info("persist user "+ user.toString());
		session.close();

	}

	@Override
	public User getUserById(int id) {
		Session session = ConnectionUtil.getSession();
		User user = (User) session.get(User.class, id);
	    session.close();
		log.info("get user by id "+ user.toString());
	    return user;
	}

}
