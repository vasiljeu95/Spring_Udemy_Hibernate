package org.example.hibernate_test.tests;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Test3
 *
 * @author Stepan Vasilyeu
 * @since 03.06.2022
 */
public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            List<Employee> employeeList = session.createQuery("FROM Employee WHERE name = 'Oleg' AND salary > 600").getResultList();
            for (Employee employee: employeeList)
                System.out.println(employee);
            session.getTransaction().commit();
        } finally {

            sessionFactory.close();
        }
    }
}
