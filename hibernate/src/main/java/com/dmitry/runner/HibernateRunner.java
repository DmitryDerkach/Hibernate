package com.dmitry.runner;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dmitry.entity.Birthday;
import com.dmitry.entity.Company;
import com.dmitry.entity.PersonalInfo;
import com.dmitry.entity.User;
import com.dmitry.util.HibernateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HibernateRunner {

    public static void main(String[] args) throws SQLException {
        Company company = Company.builder()
                .name("Amazon")
                .build();
        User user = User.builder()
                .username("ivan@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .lastname("Petrov")
                        .firstname("Petr")
                        .birthDate(new Birthday(LocalDate.of(2000, 1, 2)))
                        .build())
                .company(company)
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();

                session1.save(user);

                session1.getTransaction().commit();
            }
        }
    }
}
