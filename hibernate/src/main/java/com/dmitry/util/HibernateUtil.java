package com.dmitry.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import com.dmitry.converter.BirthdayConverter;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HibernateUtil {

	public static SessionFactory buildSessionFactory() {
		
		Configuration configuration = new Configuration();
		configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
		configuration.addAttributeConverter(new BirthdayConverter(), true);
		configuration.registerTypeOverride(new JsonBinaryType());
		configuration.configure();
		
		return configuration.buildSessionFactory();
	}
}
