package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionUtil {

	private static SessionFactory sessionFactory (String filename){
		Configuration conf = new Configuration().configure(filename);
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		return conf.buildSessionFactory(sr);
	}

	public static Session getSession(){
		return sessionFactory("hibernate.cfg.xml").openSession();
	}
}
