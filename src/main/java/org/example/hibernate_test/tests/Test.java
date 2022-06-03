package org.example.hibernate_test.tests;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Test
 *
 * @author Stepan Vasilyeu
 * @since 03.06.2022
 */
public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Stepan", "Vasilyeu", "IT", 500);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
