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
public class UpdateTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            session.createQuery("UPDATE Employee SET salary = 7500 WHERE name = 'Vlad'").executeUpdate();
            session.createQuery("UPDATE Employee SET salary = 750 WHERE department = 'HR'").executeUpdate();

//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(1500);

            session.getTransaction().commit();
        } finally {

            sessionFactory.close();
        }
    }
}
