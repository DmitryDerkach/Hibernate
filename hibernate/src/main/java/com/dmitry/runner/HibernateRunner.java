package com.dmitry.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmitry.entity.PersonalInfo;
import com.dmitry.entity.User;
import com.dmitry.util.HibernateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HibernateRunner {
	
	public static void main(String[] args) {
		//По отношению к любой из сессий User нах-ся в состоянии Transient
		User user = User.builder()
			.username("peter2@gmail.com")
			.personalInfo(PersonalInfo.builder()
					.lastname("Petrov")
					.firstname("Peter")
					.build())
			.build();
		log.info("User entity in transient state, object: {}", user);
		
		try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
			Session session1 = sessionFactory.openSession();
			try(session1) {
				var transaction = session1.beginTransaction();
				log.info("Transaction is created, {}", transaction);
				
				session1.saveOrUpdate(user);
				log.info("User is in persistent state: {}, session {}", user, session1);
			
				session1.getTransaction().commit();
			}
		
			log.warn("User is in detached state: {}, session is closed {}", user, session1 );
		} catch (Exception e) {
			log.error("Exception occurred", e);
			throw e;
		}
		
		
	}//main
}//class
