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
public class BiDirectionalTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

//            Employee employee = new Employee("Misha", "Ponomar", "test", 750);
//            Detail detail = new Detail("Grondo", "32143478", "ponomar98@gmail.com");

//            employee.setEmployeeDetail(detail);
//            detail.setEmployee(employee);

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 3);
            detail.getEmployee().setEmployeeDetail(null);
//            System.out.println(detail.getEmployee());
            session.delete(detail);
//            session.save(detail);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
