 package org.example.hibernateOneToManyUniDir.tests;

import org.example.hibernateOneToManyUniDir.entity.Department;
import org.example.hibernateOneToManyUniDir.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 /**
  * Test
  *
  * @author Stepan Vasilyeu
  * @since 03.06.2022
  */
 public class OneToManyUniDirectionalTest {
     public static void main(String[] args) {
         SessionFactory sessionFactory = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(Employee.class)
                 .addAnnotatedClass(Department.class)
                 .buildSessionFactory();
         Session session = null;
         try {
             //************* create new department and  employees
//             session = sessionFactory.getCurrentSession();
//
//             Department department = new Department("HR", 500, 1500);
//             Employee employee = new Employee("Oleg", "Ivanov", 800);
//             Employee employee1 = new Employee("Andrei", "Sidorov", 1000);
//
//             department.addEmployeeToDepartment(employee);
//             department.addEmployeeToDepartment(employee1);
//
//             session.beginTransaction();
//             session.save(department);
//
//             session.getTransaction().commit();
//             System.out.println("Done!");

             //************* sout department
//             session = sessionFactory.getCurrentSession();
//
//             session.beginTransaction();
//             Department department = session.get(Department.class, 2);
//             System.out.println(department);
//             System.out.println(department.getEmployeeList());
//
//             session.getTransaction().commit();
//             System.out.println("Done!");

             //************* sout employee
//             session = sessionFactory.getCurrentSession();
//
//             session.beginTransaction();
//             Employee employee = session.get(Employee.class, 3);
//             System.out.println(employee);
//
//             session.getTransaction().commit();
//             System.out.println("Done!");

             //************* delete employee
//             session = sessionFactory.getCurrentSession();
//
//             session.beginTransaction();
////             Employee employee = session.get(Employee.class, 3);
//             Department department = session.get(Department.class, 1);
//
//             session.delete(department);
//
//             session.getTransaction().commit();
//             System.out.println("Done!");
         } finally {
             session.close();
             sessionFactory.close();
         }
     }
 }
