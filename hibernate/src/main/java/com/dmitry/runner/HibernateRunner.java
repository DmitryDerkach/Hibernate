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
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

public class HibernateRunner {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		//configuration.addAnnotatedClass(User.class);
		configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
		configuration.addAttributeConverter(new BirthdayConverter(), true);
		configuration.registerTypeOverride(new JsonBinaryType());
		configuration.configure();
		
		try (SessionFactory sessionFactory = configuration.buildSessionFactory();
			 Session session = sessionFactory.openSession()) {
			
			session.beginTransaction();
			User user = User.builder()
					.username("ivan2@gmail.com")
					.firstname("Ivan")
					.lastname("Ivanov")
					.info("{\r\n"
							+ "    \"glossary\": {\r\n"
							+ "        \"title\": \"example glossary\",\r\n"
							+ "		\"GlossDiv\": {\r\n"
							+ "            \"title\": \"S\",\r\n"
							+ "			\"GlossList\": {\r\n"
							+ "                \"GlossEntry\": {\r\n"
							+ "                    \"ID\": \"SGML\",\r\n"
							+ "					\"SortAs\": \"SGML\",\r\n"
							+ "					\"GlossTerm\": \"Standard Generalized Markup Language\",\r\n"
							+ "					\"Acronym\": \"SGML\",\r\n"
							+ "					\"Abbrev\": \"ISO 8879:1986\",\r\n"
							+ "					\"GlossDef\": {\r\n"
							+ "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\r\n"
							+ "						\"GlossSeeAlso\": [\"GML\", \"XML\"]\r\n"
							+ "                    },\r\n"
							+ "					\"GlossSee\": \"markup\"\r\n"
							+ "                }\r\n"
							+ "            }\r\n"
							+ "        }\r\n"
							+ "    }\r\n"
							+ "}")
					.birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
					.role(Role.ADMIN)
					.build();
			//Сохраняем сущность в БД
			session.save(user);
			session.getTransaction().commit();
		}
	}

}
