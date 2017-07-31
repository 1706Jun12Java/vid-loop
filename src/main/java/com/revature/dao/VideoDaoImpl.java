package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.domain.Video;
import com.revature.util.ConnectionUtil;

public class VideoDaoImpl implements VideoDao {

	@Override
	public Video getVideosById(int id) {
		Session session = ConnectionUtil.getSession();
		Video vid = (Video) session.get(Video.class, id);
	    session.close();
	      return vid;
	}
	@Override
	public List<Video> getVideosByTag(String tag) {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.eq("tag", tag));
		List<Video> results = cr.list();
	    session.close();
	      return results ;
	}
	@Override
	public List<Video> getVideosByName(String name) {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.like("vidName", name,MatchMode.ANYWHERE));
		List<Video> results = cr.list();
		session.close();
		return results;
	}
	@Override
	public List<Video> getVideosByUser(int id) {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.eq("v_userId.id", id));
		List<Video> results = (List<Video>) cr.list();
		session.close();
		return results;
	}
	


	
}
