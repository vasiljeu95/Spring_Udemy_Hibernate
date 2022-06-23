 package org.example.hibernateOneToManyBiDir.tests;

import org.example.hibernateOneToManyBiDir.entity.Department;
import org.example.hibernateOneToManyBiDir.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

 /**
  * Test
  *
  * @author Stepan Vasilyeu
  * @since 03.06.2022
  */
 public class OneToManyBiDirectionalTest {
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
//             Department department = new Department("Sales", 800, 1500);
//             Employee employee = new Employee("Zaur", "Tregulov", 800);
//             Employee employee1 = new Employee("Elena", "Smirnova", 1500);
//             Employee employee2 = new Employee("Anton", "Sidorov", 1200);
//
//             department.addEmployeeToDepartment(employee);
//             department.addEmployeeToDepartment(employee1);
//             department.addEmployeeToDepartment(employee2);
//
//             session.beginTransaction();
//             session.save(department);
//
//             session.getTransaction().commit();
//             System.out.println("Done!");

             //************* sout department
             session = sessionFactory.getCurrentSession();

             session.beginTransaction();
             System.out.println("Get Department");
             Department department = session.get(Department.class, 3);
             System.out.println("Show Department");
             System.out.println(department);
             System.out.println("Show Employees");
             System.out.println(department.getEmployeeList());

             session.getTransaction().commit();
             System.out.println("Done!");

             //************* sout employee
//             session = sessionFactory.getCurrentSession();
//
//             session.beginTransaction();
//             Employee employee = session.get(Employee.class, 1);
//             System.out.println(employee);
//             System.out.println(employee.getDepartment());
//
//             session.getTransaction().commit();
//             System.out.println("Done!");

             //************* delete employee
//             session = sessionFactory.getCurrentSession();
//
//             session.beginTransaction();
//             Employee employee = session.get(Employee.class, 2);
//
//             session.delete(employee);
//
//             session.getTransaction().commit();
//             System.out.println("Done!");
         } finally {
             session.close();
             sessionFactory.close();
         }
     }
 }
