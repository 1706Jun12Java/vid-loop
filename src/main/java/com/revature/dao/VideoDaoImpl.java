package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.revature.domain.Video;
import com.revature.util.ConnectionUtil;

@Component("videoDaoImpl")
public class VideoDaoImpl implements VideoDao {

	private static Logger log = Logger.getRootLogger();

	@Override
	public Video getVideoById(int id) {
		Session session = ConnectionUtil.getSession();
		Video vid = (Video) session.get(Video.class, id);
	    session.close();
	    log.info("get video with id "+ id);
	      return vid;
	}
	@Override
	public List<Video> getVideosByTag(String tag) {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.eq("tag", tag));
		List<Video> results = cr.list();
	    session.close();
	    log.info("get videos by tag "+tag);
	      return results ;
	}
	@Override
	public List<Video> getVideosByName(String name) {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.like("vidName", name,MatchMode.ANYWHERE));
		List<Video> results = cr.list();
		session.close();
		log.info("get videos by name " + name);
		return results;
	}
	@Override
	public List<Video> getVideosByUser(int id) {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.eq("v_userId.id", id));
		List<Video> results = (List<Video>) cr.list();
		session.close();
		log.info("get videos by user id "+id);
		return results;
	}
	@Override
	public void saveVideo(Video v, int id) {
		log.info("save video "+v.toString()+" from "+id);
	}
	@Override
	public List<Video> listVideos() {
		Session session = ConnectionUtil.getSession();
		Criteria cr = session.createCriteria(Video.class);
		List<Video> results = (List<Video>) cr.list();
		session.close();
		log.info("list videos");
		return results;
	}




}
