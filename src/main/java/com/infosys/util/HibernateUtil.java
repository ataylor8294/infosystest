package com.infosys.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//Hibernate util implements a singleton design pattern
//class builds session factory only once whhen it is not created yet
//then returns already built sessionfactory if it already exists
public class HibernateUtil {
	//sessionfactory object used to create sessions in AccountDao
	private static SessionFactory sessionfactory;
	//buildsessionfactory is private and will only be called using getsessionfactory
	private static SessionFactory buildSessionFactory() {
		//Configuration is made first using the hibernate.cfg.xml file
		//returns new session factory if successful
		try {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			System.out.println("hibernate config loaded");
			SessionFactory sessionfactory = config.buildSessionFactory();
			return sessionfactory;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	//get Sessionfactory to be called to create new sessions for hibernate actions
	public static SessionFactory getSessionFactory() {
		if (sessionfactory==null) {
			sessionfactory = buildSessionFactory();
		}
		return sessionfactory;
	}
}
