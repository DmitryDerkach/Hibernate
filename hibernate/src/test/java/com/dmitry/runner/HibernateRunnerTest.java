package com.dmitry.runner;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Table;

import org.junit.Test;

import com.dmitry.entity.Company;
import com.dmitry.entity.User;
import com.dmitry.util.HibernateUtil;

import lombok.Cleanup;

public class HibernateRunnerTest {

	
    @Test
    public void deleteCompany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = session.get(Company.class, 8);
        session.delete(company);

        session.getTransaction().commit();
    }
    
    @Test
    public void addUserToNewCompany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = Company.builder()
                .name("Facebook")
                .build();

        var user = User.builder()
                .username("sveta@gmail.com")
                .build();
//        user.setCompany(company);
//        company.getUsers().add(user)
        company.addUser(user);

        session.save(company);

        session.getTransaction().commit();
    }
	
	
	
	@Test
	public void oneToMany() {
	        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
	        @Cleanup var session = sessionFactory.openSession();
	        session.beginTransaction();

	        var company = session.get(Company.class, 5);
	        System.out.println(company.getUsers());

	        session.getTransaction().commit();
	    }
	@Test
	public void checkReflectionApi() throws SQLException, IllegalArgumentException, IllegalAccessException {
		User user = User.builder()
				.build();
		
		String sql = "insert into %s (%s) values (%s)";
		
		String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
				.map(tableAnnotation -> tableAnnotation.schema() + "." + tableAnnotation.name())
				.orElse(user.getClass().getName());
		
		String columNames = Arrays.stream(user.getClass().getDeclaredFields())
				.map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
						.map(Column::name)
						.orElse(field.getName()))
				.collect(Collectors.joining(", "));
		
		String columnValues = Arrays.stream(user.getClass().getDeclaredFields())
				.map(field -> "?")
				.collect(Collectors.joining(", "));
		
//		System.out.println(sql.format(sql, tableName, columNames, columnValues));
		
//		Connection connection = null;
//		PreparedStatement prepareStatement = connection.prepareStatement(sql.format(sql, tableName, columNames, columnValues));
//		Field[] declaredFileds = user.getClass().getDeclaredFields();	
//		for (Field declaredFiled : declaredFileds) {
//			declaredFiled.setAccessible(true);
//			prepareStatement.setObject(1, declaredFiled.get(user));
//		}
	}
}
