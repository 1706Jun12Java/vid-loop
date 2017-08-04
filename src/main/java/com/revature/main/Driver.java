package com.revature.main;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.revature.dao.*;
import com.revature.domain.User;
import com.revature.domain.Video;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		//VideoDao vd = new VideoDaoImpl();
		//System.out.println(vd.getVideosById(2));
		//UserDao ud = new UserDaoImpl();
		//System.out.println(ud.getUserById(1));
		//System.out.println(vd.getVideosByTag("spooky"));
		//System.out.println(vd.getVideosByName("name"));
		//System.out.println(vd.getVideosByUser(2));

		//init();
//		s3();
		getVideos();
	}
	static void init(){
		Session s = ConnectionUtil.getSession();
		Transaction tx = s.beginTransaction();

		User user1 = new User("user1","pass","user","user","user@gmail.com");
		User user2 = new User("userx","pass","userx","userx","userx@gmail.com");

		Video vid1 = new Video(user2,"no","name",1,1,"spooky");
		Video vid2 = new Video(user2,"yes","nammmmme",1,1,"spooky");

		s.save(user1);
		s.save(user2);
		s.save(vid1);
		s.save(vid2);

		tx.commit();
		s.close();
	}

	static void s3(){
		final String bucket = "famtubestorage/vids";
		Date d = new Date();
		String filename=d.getTime()+".mp4";


        try {
        	AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        	System.out.println(filename);
        	System.out.println(s3.listBuckets().toString());
        	File file = new File("C:/Users/Christian/Desktop/test");
        	PutObjectResult x = s3.putObject(new PutObjectRequest(bucket, filename, file).withCannedAcl(CannedAccessControlList.PublicRead));
        	System.out.println(x.getETag());
        } catch (AmazonServiceException e) {
        	e.printStackTrace();
        } catch(AmazonClientException e){
        	e.printStackTrace();
        }
        System.out.println("Done!");
	}
	
	static void getVideos(){
		List<Video> videos = new ArrayList<Video>();
		Session s = ConnectionUtil.getSession();
		videos = s.createQuery("from Video").list();
		s.close();
		System.out.println(videos);
	}
	
}
