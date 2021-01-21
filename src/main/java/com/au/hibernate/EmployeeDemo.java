package com.au.hibernate;

import com.au.hibernate.entiity.Address;
import com.au.hibernate.entiity.Course;
import com.au.hibernate.entiity.Employee;
import com.au.hibernate.entiity.EmployeeDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(EmployeeDetails.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        Employee employee = new Employee("Praba", "kar");
        Employee employee1 = new Employee("Soumya", "Racha");
        EmployeeDetails employeeDetails1 = new EmployeeDetails("987654321","praba@mail.com", employee);
        EmployeeDetails employeeDetails2 = new EmployeeDetails("9876765671","soumya@mail.com", employee1);


        Address address1 = new Address("MNLR", "Trichy", "621005", employee);
        Address address2 = new Address("Rayapuram", "Chennai", "600026", employee);
        Address address3 = new Address("Nanded", "Hyderabad", "543215", employee1);

        employee.getAddressList().add(address1);
        employee.getAddressList().add(address2);

        employee1.getAddressList().add(address3);


        Course course1 = new Course();
        Course course2 = new Course();

        course1.setCourseName("Hibernate");
        course2.setCourseName("Spring");

        employee.getCourse().add(course1);
        employee.getCourse().add(course2);
        employee1.getCourse().add(course1);
        employee1.getCourse().add(course1);

        course1.getEmployeeList().add(employee);
        course2.getEmployeeList().add(employee);
        course1.getEmployeeList().add(employee1);
        course2.getEmployeeList().add(employee1);



        try {
            session.beginTransaction();

            session.save(employee);
            session.save(employee1);
            session.save(employeeDetails1);
            session.save(employeeDetails2);

            session.getTransaction().commit();
            session.close();

            session = sessionFactory.openSession();
            Employee empGetDB = session.get(Employee.class, 1);
            session.close();

        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
