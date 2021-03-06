package com.revature.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.domain.*;
import com.revature.util.ConnectionUtil;
import java.util.*;

@Component("commentDaoImpl")
public class CommentDaoImpl implements CommentDao {
	@Autowired
	ConnectionUtil cu;
	
	@Override
	public Comment addComment(String str, int vId, int uId) {
		UserDao ud = new UserDaoImpl();
		VideoDao vd = new VideoDaoImpl();
		Session session = cu.getSession();
		Transaction tx = session.beginTransaction();

		Comment comment = new Comment();
		comment.setComment(str);
		Video vid = vd.getVideoById(vId);
		comment.setVid(vid);
		User user = ud.getUserById(uId);
		comment.setUser(user);

		session.save(comment);
		tx.commit();
		session.close();
		return comment;
	}

	@Override
	public List<Comment> getCommentsByVideo(int id) {
		Session session = cu.getSession();
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("vid.id", id));
		List<Comment> results = (List<Comment>) cr.list();
		session.close();
		return results;
	}
}
