package com.revature.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
