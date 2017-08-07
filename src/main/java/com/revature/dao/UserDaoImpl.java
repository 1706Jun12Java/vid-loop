package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.domain.User;
import com.revature.domain.Video;
import com.revature.util.ConnectionUtil;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	ConnectionUtil cu;
	private static Logger log = Logger.getRootLogger();

	@Override
	public void persistUser(User user) {
		Session session = cu.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		log.info("persist user "+ user.toString());
		session.close();

	}

	
	@Override
	public User loginUser(String username, String password) {
		Session s = cu.getSession();
		Query q = s.createQuery("select id, username from User where username=:username and password=:password");
		q.setString("username", username);
		q.setString("password", password);
		User user = (User) q.list();
		return user;
	}
	
	@Override
	public User getUserById(int id) {
		Session s = cu.getSession();
		Criteria c = s.createCriteria(User.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("username"),"username"))
				.setResultTransformer(Transformers.aliasToBean(User.class));
		User user = (User) c.list().get(0);
	    s.close();
		log.info("get user by id "+ user.toString());
	    return user;
	}

}
