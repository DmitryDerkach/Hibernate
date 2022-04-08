package com.dmitry.runner;

import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import com.dmitry.converter.BirthdayConverter;
import com.dmitry.entity.Birthday;
import com.dmitry.entity.Role;
import com.dmitry.entity.User;
import com.dmitry.util.HibernateUtil;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

public class HibernateRunner {

	public static void main(String[] args) {
		//По отношению к любой из сессий User нах-ся в состоянии Transient
		User user = User.builder()
			.username("ivan@gamil.com")
			.lastname("Ivanov")
			.firstname("Ivan")
			.build();
		
//		try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
//			 Session session1 = sessionFactory.openSession()) {
//			session1.beginTransaction();
//			//В 30 строчке User будет в Persistent состоянии по отношению к session1, но все еще в состаянии transient по отношению
//			//к session 2, потому что не был никак проассоциирован с этой сессией
//			session1.saveOrUpdate(user);
//			
//			//Зыкрываем сессию - сессия перестает существовать
//			session1.getTransaction().commit();
//		}
		
		try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
				 Session session2 = sessionFactory.openSession()) {
				//Смотря в дебаге на session2 мы видим, что РС = null
				session2.beginTransaction();
				user.setFirstname("Sveta");
				//В кэшэ появляется user 
				//session2.delete(user);
				//session2.refresh(user);
				//session2.merge(user);
				session2.refresh(user);
				
				//Транзакция завершается user переходит в состояние removed по отношению к session2
				session2.getTransaction().commit();
		}
		
		
	}//main
}//class
