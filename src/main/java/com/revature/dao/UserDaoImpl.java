package com.revature.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.revature.domain.User;
import com.revature.domain.Video;
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
		Session s = ConnectionUtil.getSession();
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
