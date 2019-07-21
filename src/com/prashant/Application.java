package com.prashant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prashant.dto.UserDetails;

public class Application {

	public static void main(String[] args) throws Exception {
		
		UserDetails userDetails = new UserDetails();
		//userDetails.setUserId(1);
		userDetails.setUserName("john");
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		UserDetails userDetails2 = session.get(UserDetails.class, 1L);
		session.close();
		System.out.println("UserName: "+userDetails2.getUserName());
	
		System.out.println(userDetails2.toJson());
	}

}
