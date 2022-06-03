package org.example.hibernate_test.tests;

import org.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Test3
 *
 * @author Stepan Vasilyeu
 * @since 03.06.2022
 */
public class DeleteTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);
            session.createQuery("DELETE Employee WHERE department = 'HR'").executeUpdate();

            session.getTransaction().commit();
        } finally {

            sessionFactory.close();
        }
    }
}
