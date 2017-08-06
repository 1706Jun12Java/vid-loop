package com.revature.dao;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.revature.domain.User;
import com.revature.domain.Video;
import com.revature.util.ConnectionUtil;

@Component("videoDaoImpl")
public class VideoDaoImpl implements VideoDao {

	@Autowired
	ConnectionUtil cu;
	private static Logger log = Logger.getRootLogger();

	@Override
	public Video getVideoById(int id) {
		Session session = cu.getSession();
		Video vid = (Video) session.get(Video.class, id);
	    session.close();
	    log.info("get video with id "+ id);
	      return vid;
	}
	@Override
	public List<Video> getVideosByTag(String tag) {
		Session session = cu.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.eq("tag", tag));
		List<Video> results = cr.list();
	    session.close();
	    log.info("get videos by tag "+tag);
	      return results ;
	}
	@Override
	public List<Video> getVideosByName(String name) {
		Session session = cu.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.like("vidName", name,MatchMode.ANYWHERE));
		List<Video> results = cr.list();
		session.close();
		log.info("get videos by name " + name);
		return results;
	}
	@Override
	public List<Video> getVideosByUser(int id) {
		Session session = cu.getSession();
		Criteria cr = session.createCriteria(Video.class);
		cr.add(Restrictions.eq("v_userId.id", id));
		List<Video> results = (List<Video>) cr.list();
		session.close();
		log.info("get videos by user id "+id);
		return results;
	}
	
	@Override
	@Transactional
	public Video saveVideo(File file, int id, String vidName, String tag) {
		//TODO not done
		final String bucket = "famtubestorage/vids";
		Date d = new Date();
		String fileExtension = getFileExtension(file);
		String filename=d.getTime()+"."+fileExtension;
		String link = "https://s3.amazonaws.com/famtubestorage/vids/"+filename;
		
        try {
        	AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        	System.out.println(filename);
        	System.out.println(s3.listBuckets().toString());
        	PutObjectResult x = s3.putObject(new PutObjectRequest(bucket, filename, file).withCannedAcl(CannedAccessControlList.PublicRead));
        	System.out.println(x.getETag());
        	System.out.println("Done!");
    		log.info("save video "+file.getName());
    		UserDao ud = new UserDaoImpl();
    		User user = ud.getUserById(id);
    		Video v = new Video(user, link, vidName, 0,0,tag);
    		System.out.println(v.toString());
    		Session s = cu.getSession();
    		Transaction tx = s.beginTransaction();
    		s.save(v);
    		tx.commit();
    		s.close();
    		return v;
    		
        } catch (AmazonServiceException e) {
        	e.printStackTrace();
        } catch(AmazonClientException e){
        	e.printStackTrace();
        }
        
        return null;
        
	}
	@Override
	public List<Video> listVideos() {
		List<Video> videos = new ArrayList<Video>();
		Session s = cu.getSession();
		videos = s.createQuery("from Video").list();
		s.close();
		System.out.println(videos);
		log.info("get all videos ");
		return videos;
	}


	static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
	
	@Override
	@Transactional
	public void incrementCount(int id) {
		Session s = cu.getSession();
		Query q = s.createQuery("update Video set loopCount=loopCount+1 where id=:id");
		q.setInteger("id", id);
		q.executeUpdate();
		s.close();
	}


}
