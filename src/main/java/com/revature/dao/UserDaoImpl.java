package com.revature.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.User;

@Transactional
public class UserDaoImpl implements UserDao {
	
	private static Logger log = Logger.getRootLogger();
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void persistUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
		log.info("persist user "+ user.toString());
	}

	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		log.info("get user by id "+ user.toString());
	    return user;
	}

}
