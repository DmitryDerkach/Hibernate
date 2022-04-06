package com.dmitry.runner;

import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import com.dmitry.entity.User;

public class HibernateRunner {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		//configuration.addAnnotatedClass(User.class);
		configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
		configuration.configure();
		
		try (SessionFactory sessionFactory = configuration.buildSessionFactory();
			 Session session = sessionFactory.openSession()) {
			
			session.beginTransaction();
			User user = User.builder()
					.username("ivan@gmail.com")
					.firstname("Ivan")
					.lastname("Ivanov")
					.birthDate(LocalDate.of(2000, 1, 19))
					.age(20) 
					.build();
			//Сохраняем сущность в БД
			session.save(user);
			session.getTransaction().commit();
		}
	}

}
