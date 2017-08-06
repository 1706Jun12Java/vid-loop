package com.revature.main;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.multipart.MultipartFile;

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
import com.revature.domain.Comment;
import com.revature.domain.User;
import com.revature.domain.Video;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		

//		init();
//		s3();
//		getVideos();
//		getFileExtension();
		
	}
	static void init(){
		ConnectionUtil cu = new ConnectionUtil();
		Session s = cu.getSession();
		Transaction tx = s.beginTransaction();

		User user1 = new User("user1","pass","user","user","user@gmail.com");
		User user2 = new User("userx","pass","userx","userx","userx@gmail.com");

		Video vid1 = new Video(user2,"https://s3.amazonaws.com/famtubestorage/vids/1501698157864.mp4","name",1,1,"spooky");
		Video vid2 = new Video(user2,"https://s3.amazonaws.com/famtubestorage/vids/1501698157864.mp4","nammmmme",1,1,"spooky");
		
		Comment c1 = new Comment(user1,vid1,"asdfasdf");
		Comment c2 = new Comment(user2,vid1,"yea");
		Comment c3 = new Comment(user2,vid2,"good comment");
		Comment c4 = new Comment(user1,vid2,"nah");

		s.save(user1);
		s.save(user2);
		s.save(vid1);
		s.save(vid2);
		s.save(c1);
		s.save(c2);
		s.save(c3);
		s.save(c4);

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
		VideoDao vd = new VideoDaoImpl();
		System.out.println(vd.listVideos());
	}
	
	static void getFileExtension() {
		File file = new File("C:/Users/Christian/Desktop/test.mp4");
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        System.out.println(fileName.substring(fileName.lastIndexOf(".")+1));
    }
	
}
