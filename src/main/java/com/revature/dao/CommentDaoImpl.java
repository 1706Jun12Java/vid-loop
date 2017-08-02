package com.revature.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.domain.*;
import com.revature.util.ConnectionUtil;
import java.util.*;

public class CommentDaoImpl implements CommentDao {
	
	@Override
	public Comment addComment(String str, int vId, int uId) {
		UserDao ud = new UserDaoImpl();
		VideoDao vd = new VideoDaoImpl();
		Session session = ConnectionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Comment comment = new Comment();
		comment.setComment(str);
		Video vid = vd.getVideoById(vId);
		comment.setVid(vid);
		User user = ud.getUserById(uId);
		comment.setC_user(user);

		session.save(comment);
		tx.commit();
		session.close();
		return comment;
	}

	@Override
	public List<Comment> getCommentsByVideo(int id) {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("vid.id", id));
		List<Comment> results = (List<Comment>) cr.list();
		session.close();
		return results;
	}
}
