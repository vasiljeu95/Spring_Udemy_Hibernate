package org.example.hibernateOneToManyUniDir.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Employee
 *
 * @author Stepan Vasilyeu
 * @since 03.06.2022
 */
@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "salary")
    private int salary;

    public Employee() {}
    public Employee(String name, String surName, int salary) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
