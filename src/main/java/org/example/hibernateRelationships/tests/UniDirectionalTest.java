package org.example.hibernateRelationships.tests;

import org.example.hibernateRelationships.entity.Detail;
import org.example.hibernateRelationships.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Test
 *
 * @author Stepan Vasilyeu
 * @since 03.06.2022
 */
public class UniDirectionalTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

//            Employee employee = new Employee("Vlad", "Nordland", "Java dev", 7500);
//            Detail detail = new Detail("Minsk", "32145678", "nordland96@gmail.com");
//
//            employee.setEmployeeDetail(detail);

            session.beginTransaction();
//            session.save(employee);
            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee.getEmployeeDetail());
            session.delete(employee);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
