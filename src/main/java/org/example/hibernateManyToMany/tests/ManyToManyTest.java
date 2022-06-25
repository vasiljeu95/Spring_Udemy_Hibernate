package org.example.hibernateManyToMany.tests;

import org.example.hibernateManyToMany.entity.Child;
import org.example.hibernateManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.SecureCacheResponse;

/**
 * ManyToManyTest
 *
 * @author Stepan Vasilyeu
 * @since 23.06.2022
 */
public class ManyToManyTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            // ********************* Create and filling new Section and Children
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Zaur", 5);
//            Child child2 = new Child("Marietta", 8);
//            Child child3 = new Child("Oleh", 7);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//            session.persist(section1);

//            // ******************** Create and filling new Sections in Children
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//            session.persist(child1);

//            // ******************** Get information about children from the section
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());

//            // ******************** Get information about sections from the children
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSections());

//            // ******************** Delete sections
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 3);
//            session.delete(section);

            // ******************** Delete child
            session.beginTransaction();

            Child child = session.get(Child.class, 4);
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("DONE !!!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
